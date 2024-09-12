Possible commands are:
 * easy instantiate <src_folder> <trg_folder>
 * easy instantiate <src_folder> <trg_folder> <absolute path to ivml_file> <absolute path to vil_file>
 * easy instantiate <src_folder> <trg_folder> <ivml name> <ivml version> <vil name> <vil version>
 
 * easy instantiateSelf <project_folder>
 * easy instantiateSelf <project_folder> <absolute path to ivml_file>
 * easy instantiateSelf <project_folder> <absolute path to ivml_file> <absolute path to vil_file>
 
 * easy checkValidity <project_folder> - This will check the main ivml file inside of the specified project. This must be a complete EASy-Producer project, i.e., a project which was created inside Eclipse. The result will be stored inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.
 * easy checkValidity <project_folder> <absolute path to ivml_file> - This will check the ivml file inside of the specified project. The result will be stored inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.
 * easy checkValidity <project_folder> <ivml project name> <ivml project version> - This will load a ivml file out of the project with the specified name and version. This will check the ivml file inside of the specified project. The result will be storred inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.

Command line exit codes:
    0: successful
    1: I/O issue
    2: model loading/path issue
    3: EASy project loading issue
    4: VIL/VTL execution failed
    5: version syntax/format issue
    6: VIL/VTL undefined value execution issue
    7: security issue (file access)
    8: unexpected (wrong) index, e.g., command line arguments
    10: reasoning failed, see messages
    11: no reasoner found
