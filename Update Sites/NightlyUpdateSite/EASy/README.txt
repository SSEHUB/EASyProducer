EASy-Producer nightly products. Tested with Java 8, Java 13.

Java 9: 
  requires modification to QualiMasterApplication.ini, here one working with for OpenJDK 10
  
--launcher.appendVmargs
-vmargs
-Xms512M
-Xmx1024M
-Divml.configuration.new=true
-Dorg.osgi.framework.bundle.parent=ext
-Dosgi.requiredJavaVersion=1.8
--add-modules=ALL-SYSTEM
