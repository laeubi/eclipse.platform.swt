/*******************************************************************************
 * Copyright (c) 2026 Contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Contributors - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.Display;

/**
 * Snippet to demonstrate potential race condition in ImageHandleManager.
 * 
 * This snippet creates multiple threads that concurrently access the same Image
 * at the same zoom level, which could trigger the race condition in 
 * ImageHandleManager.getOrCreate() if it's not properly synchronized.
 * 
 * The race condition occurs when:
 * 1. Thread A calls getOrCreate(zoom) - checks if handle exists (returns null)
 * 2. Thread B calls getOrCreate(zoom) - checks if handle exists (returns null)
 * 3. Thread A creates new handle via creator.get()
 * 4. Thread B creates ANOTHER handle via creator.get() (wasteful!)
 * 5. Both threads put() their handles, one overwrites the other (resource leak!)
 * 
 * For instructions on how to use this snippet, see:
 * http://www.eclipse.org/swt/
 */
public class Snippet_ImageHandleRaceCondition {
	
	private static final int NUM_THREADS = 20;
	private static final int ITERATIONS_PER_THREAD = 100;
	private static final int TARGET_ZOOM = 150;
	
	// Track handle creation to detect duplicate creations
	private static final AtomicInteger handleCreationCount = new AtomicInteger(0);
	private static final ConcurrentHashMap<Integer, Integer> handleCreationsByZoom = new ConcurrentHashMap<>();

	public static void main(String[] args) throws Exception {
		Display display = new Display();
		
		System.out.println("=== ImageHandleManager Race Condition Test ===");
		System.out.println("This test attempts to trigger the race condition by having");
		System.out.println("multiple threads concurrently access the same Image at the same zoom level.\n");
		
		// Create an ImageDataProvider that tracks handle creations
		ImageDataProvider provider = new ImageDataProvider() {
			@Override
			public ImageData getImageData(int zoom) {
				// Track each time we're asked to create image data for a zoom level
				int count = handleCreationsByZoom.compute(zoom, (k, v) -> v == null ? 1 : v + 1);
				handleCreationCount.incrementAndGet();
				
				// Add a small delay to increase chance of race condition
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				
				// Create image data
				int size = 16 * zoom / 100;
				ImageData imageData = new ImageData(size, size, 24, 
					new PaletteData(0xFF, 0xFF00, 0xFF0000));
				
				// Fill with a simple pattern
				for (int y = 0; y < size; y++) {
					for (int x = 0; x < size; x++) {
						imageData.setPixel(x, y, (x + y) % 2 == 0 ? 0xFFFFFF : 0x000000);
					}
				}
				
				if (count > 1) {
					System.err.println("WARNING: Image data requested " + count + " times for zoom " + zoom + 
						" (possible race condition!)");
				}
				
				return imageData;
			}
		};
		
		Image image = new Image(display, provider);
		
		// Force initial creation at 100% zoom
		image.getImageData(100);
		handleCreationsByZoom.clear();
		handleCreationCount.set(0);
		
		System.out.println("Starting concurrent access test with " + NUM_THREADS + " threads...\n");
		
		// Create thread pool
		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch doneLatch = new CountDownLatch(NUM_THREADS);
		
		// Submit tasks that will all try to access the image at the same zoom level
		for (int i = 0; i < NUM_THREADS; i++) {
			final int threadId = i;
			executor.submit(() -> {
				try {
					// Wait for all threads to be ready
					startLatch.await();
					
					// Each thread tries to get the image handle multiple times
					for (int j = 0; j < ITERATIONS_PER_THREAD; j++) {
						display.syncExec(() -> {
							try {
								// This should trigger getOrCreate() in ImageHandleManager
								@SuppressWarnings("unused")
								long handle = Image.win32_getHandle(image, TARGET_ZOOM);
							} catch (Exception e) {
								System.err.println("Thread " + threadId + " iteration " + j + " failed: " + e.getMessage());
								e.printStackTrace();
							}
						});
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					doneLatch.countDown();
				}
			});
		}
		
		// Start all threads at once
		startLatch.countDown();
		
		// Wait for completion
		doneLatch.await();
		executor.shutdown();
		executor.awaitTermination(30, TimeUnit.SECONDS);
		
		// Report results
		System.out.println("\n=== Test Results ===");
		System.out.println("Total image data creations: " + handleCreationCount.get());
		System.out.println("Creations by zoom level:");
		handleCreationsByZoom.forEach((zoom, count) -> 
			System.out.println("  Zoom " + zoom + ": " + count + " creation(s)"));
		
		int creationsForTargetZoom = handleCreationsByZoom.getOrDefault(TARGET_ZOOM, 0);
		if (creationsForTargetZoom > 1) {
			System.err.println("\n❌ RACE CONDITION DETECTED!");
			System.err.println("Image data was created " + creationsForTargetZoom + 
				" times for zoom " + TARGET_ZOOM);
			System.err.println("Expected: 1 creation");
			System.err.println("This indicates that multiple threads created duplicate handles.");
		} else if (creationsForTargetZoom == 1) {
			System.out.println("\n✓ No race condition detected (or it didn't manifest in this run)");
			System.out.println("Note: Race conditions are non-deterministic; absence of detection");
			System.out.println("doesn't guarantee the code is thread-safe.");
		} else {
			System.out.println("\n⚠ Zoom level " + TARGET_ZOOM + " was never accessed");
		}
		
		image.dispose();
		display.dispose();
	}
}
