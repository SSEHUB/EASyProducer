The construction of test cases is similar to the VIL build language. Thils file
details some extensions:

- trace file
  1) for alternatives either "visit if-branch" or "visit else-branch" (but only if present) 
     are emitted depending on the actual evaluation of the condition
  2) for a loop basically 
       for <variable> {
       }
     is emitted and for each assignment of the loop variable a nested <variable> <- <value>

- output file
  the actual expected output (to be compared as part of the tests)