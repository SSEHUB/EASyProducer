SSE-Eclipse 4.7.2: Dropins currently contains org.apache.commons.io_2.4.0.jar

Several core plugins seem to be installed/provisioned in duplicated manner. For creating an Eclipse-based launch configuration (Application, jUnit):
  - deselect all plugins
  - select test plugin
  - add both google.guava
  - ensure that the following plugins are enabled (latest version)
    - org.eclipse.platform
    - org.eclipse.equinox.event
    - org.eclipse.equinox.ds 
  - set VM argument Deasy.notInEclipse=true
