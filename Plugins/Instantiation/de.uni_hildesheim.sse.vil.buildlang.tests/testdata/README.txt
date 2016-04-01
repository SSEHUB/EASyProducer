1) Do not delete temp! Do not put or commit any files to temp as this directory will be used for putting artifacts per 
   test into and removing them afterwards.
   
2) Basically, VIL scripts are used for testing the VIL parser and the semantic analysis. This is akin to testing
   IVML files. For details, see de.uni_hildesheim.sse.ivml.tests/testdata/README.txt. 
   
3) For execution tests, each VIL is accompanied with a respective trace file (.trc). Trace files state the operations
   performed during execution in a nested way, i.e., contained execution parts are denoted by an indentation of 4 
   spaces (no tabs). Currently, 
     - a rule call looks like
         -> ruleName(paramTypes) with (arguments)
     - a value assignment to a variable looks like
         varName <- value
     - a method call looks like
         -> methodName(paramTypes) with (arguments) = result
     - a system call looks like
         system call(arguments)
   Basically, all instances from the VIL models are turned into strings in the following way
     - a string is just printed as it is (without surrounding ")
     - a path is turned into its path name. If located within a project's artifact model, paths are given in relative 
       form.
     - a collection is printed as {val1, val2, ...} whereby the values are produced according to the string
       rules above and the values are given in alphabetical order in order to release dependencies on the file system
     