# Identify Spam origin (NameIdentify)
This is a simple project to insert a traceable snip of text into 
the name you give a website.

## Running
1. Clone the repository to your local machine with `git clone`
2. `cd` into the directory
3. Using _sbt_ run using `sbt run`
4. Follow the command line prompts

_nb: The command line migh show extra spacing, but it wont show outside the command line_

## Example

If you give the program the secret `Google` and the name `Jack`
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