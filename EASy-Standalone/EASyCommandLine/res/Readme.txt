Possible commands are:
 * easy instantiate <src_folder> <trg_folder>
 * easy instantiate <src_folder> <trg_folder> <absolute path to ivml_file> <absolute path to vil_file>
 * easy instantiate <src_folder> <trg_folder> <ivml name> <ivml version> <vil name> <vil version>
 
 * easy debug instantiate <src_folder> <trg_folder>
 * easy debug instantiate <src_folder> <trg_folder> <absolute path to ivml_file> <absolute path to vil_file>
 * easy debug instantiate <src_folder> <trg_folder> <ivml name> <ivml version> <vil name> <vil version>
 
 * easy instantiateSelf <project_folder>
 * easy instantiateSelf <project_folder> <absolute path to ivml_file>
 * easy instantiateSelf <project_folder> <absolute path to ivml_file> <absolute path to vil_file>
 
 * easy debug instantiateSelf <project_folder>
 * easy debug instantiateSelf <project_folder> <absolute path to ivml_file>
 * easy debug instantiateSelf <project_folder> <absolute path to ivml_file> <absolute path to vil_file>
 
 * easy checkValidity <project_folder> <absolute path to ivml_file> - This will check the ivml file inside of the specified project. The result will be storred inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.
 * easy checkValidity <project_folder> <ivml project name> <ivml project version> - This will load a ivml file out of the project with the specified name and version. This will check the ivml file inside of the specified project. The result will be storred inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.
  
 * easy debug checkValidity <project_folder> <absolute path to ivml_file> - This will check the ivml file inside of the specified project. The result will be storred inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.
 * easy debug checkValidity <project_folder> <ivml project name> <ivml project version> - This will load a ivml file out of the project with the specified name and version. This will check the ivml file inside of the specified project. The result will be storred inside of the project in a file named ".result". The file will contain a
   - true: The specified ivml_file constains at least one conflict.
   - false: No conflicts where detected inside given ivml_file.