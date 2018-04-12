# Identify Spam origin (NameIdentify)
This is a simple project to insert a traceable snip of text into 
the name you give a website.

[Documentation](https://jdtechnology.github.io/Identify-Spam-Origin/com/jd/nameidentify/index.html "github pages")

### Pre-requisites
You should have
1. [scala >= 2.12.0](https://www.scala-lang.org/download/)
2. [sbt >= 1.1.0](https://www.scala-sbt.org/download.html)
3. A computer with a terminal

## Running
1. Clone the repository to your local machine with `git clone`
2. `cd` into the directory
3. Run the shell script using `./run.sh`
4. Follow the command line prompts

_nb: The command line migh show extra spacing, but it wont show outside the command line_

## Example

If you give the program the secret `Google` and the name `Jack`,
your word with the secret embedded will be: `J​​‌⁠‌⁠​​‌​⁠﻿ack`.

_Hint: copy `J​​‌⁠‌⁠​​‌​⁠﻿ack` into [Diff Checker](https://www.diffchecker.com/) to see it **is** there._

## Contributing
All contributions accepted, before submitting a pull request, please run the precheck file,
and ensure it passes.
```bash
./precheck.sh
```
The script is located in the root directory.
### Author
[Jack Fisher](https://github.com/jdtechnology)