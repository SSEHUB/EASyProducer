Tests in IVML are parsed, analyzed, printed by the IVML writer and textually compared to the input file. For each test a call
in a JUnit test specifies the name of the file, the expected project name, the expected version and the expected error codes (if required).

- Basic tests: basic language functionality testing with knowledge about the implementation in background
- Advanced tests: advanced language functionality testing with knowledge about the implementation in background

Further tests shall be located in further directories and called by additional JUnit tests registered in the overall test suite.

Please note that the project names/versions need to be unique as the entire testdata directory is scanned for projects at the beginning. All
projects may refer to each other as imports are resolved.
Please refrain from using simple names such as "test" as they are used for failing tests on imports. Please check
the other tests for their project names and versions before defining own test cases!

Special comment syntax in test files: (see e.g. constraints.ivml)
- Due to textual comparison only the canonical output of the IVML writer can be specified in IVML files, i.e. alternative notations of 
  operations are not recognized. Basic data type operations are typically infix or prefix, the others in functional notation.
- Indentation is 4 spaces, no tabs. Please remove any superfluous spaces at the end of a line and avoid empty lines (except for empty lines
  inserted by the IVML writer). Definitions go first in sequence of their dependencies.
- In order to test notational alternatives, please specify in the line before the expression a //* comment at correct indentation and the 
  expression to test in the next line. Example
      //* (i1 <> i2) or (i1 = i2);
      (i1 <> i2) or (i1 == i2);
  During comparison the second line is replaced by the first as expected output of the IVML writer.
- Comments need to be placed the the leftmost position of a line as line comments. These lines are skipped during comparison
