---
name: Isse Checker
description: Checks a repository for issues that are outdated or already fixed
---

# Issue Agent

Fetch all [open issues](https://github.com/eclipse-platform/eclipse.platform.swt/issues) and create a report.

Checking Issues should include:

1) If the issue already fixed, e.g. is the problem described reproducible and do we have a snippet and the problem can not be reproduced anymore with the current codebase
2) If no snippet to test is there try to derive a [minimal reproducer](http://www.sscce.org/)
3) If no snippet can be derived we need to ask the author for more details

A report would then:

- List all open issues that are likley already fixed
- Issues for what minimal reproducer could be derived and the snippet to reproduce it (e.g. as Snippet_Issue<issunumer>.java)
- Issues for what more information are needed and what likley is required (e.g. crash dump, stacktrace, ...)
