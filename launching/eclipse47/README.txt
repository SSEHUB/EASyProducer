If you upgraded your workspace
  - Please check that your target platform is correctly defined, e.g., 32/64 bit
Executing/Debugging EASy requires
  - JDK as installed JRE in particular having JDK 9 installed as otherwise the Java compiler is not available
  - Eclipse may open the validation results indicating that javax.xml.bind is missing. This does not cause harm to launching EASy/tests. Although we tried to install javax.xml.bin, Eclipse continued complaining. The remaining platform-specific bundles are just warnings.