IIP-Ecosphere platform instance

For understanding the components and how to explore the platform, we recommend reading the platform handbook on:
  - https://www.iip-ecosphere.eu/
  - https://doi.org/10.5281/zenodo.5168946

This is an assembled and instantiated version of the IIP-Ecosphere platform of version 0.5.0-SNAPSHOT. 
Components that are not configured to be part of the platform are left out. Glue code for services, wire 
format serializers for application specific data types, logging configurations etc. are generated and packaged. 
IP-Addresses for the central services became part of the binaries during packaging.

This folder contains the top-level artifacts that are needed to execute the platform (in the following sequence):
  - The communication broker. If possible, we instantiate a working broker into the broker folder. System or 
    device brokers providing the same functionality may be used instead.
    - broker.bat for Windows and JDK > 8 and JDK <= 13
    - broker.sh for Linux/Bash and JDK > 8 and JDK <= 13
    - setup in src
    - binaries in "brokerJars"
    - iip-broker.service for Linux/systemd and JDK > 8 and JDK <= 13
  - The central platform services, in particular the AAS server (due to various components, JDK 8 is not 
    feasible for the central platform services)
    - platform.bat for Windows and JDK > 8 and JDK <= 13
    - platform.sh for Linux/Bash and JDK > 8 and JDK <= 13
    - source code in "platform"
    - binaries in "plJars"
    - iip-platform.service for Linux/systemd and JDK > 8 and JDK <= 13
  - The central monitoring component (if configured, as long as BaSyx, Tomcat and monitoring do conflict)
    - monitoring.bat for Windows and JDK > 8 and JDK <= 13
    - monitoring.sh for Linux/Bash and JDK > 8 and JDK <= 13
    - source code in "monitoring"
    - binaries in "monJars"
    - iip-monitoring.service for Linux/systemd and JDK > 8 and JDK <= 13
  - The ECS runtime with container manager
    - ecs.bat for Windows and JDK > 8 and JDK <= 13, ecs8.bat for Windows and JDK 8
    - ecs.sh for Linux/Bash and JDK > 8 and JDK <= 13, ecs8.sh for Linux/Bash and JDK 8
    - source code in "ecsRuntime"
    - binaries in "ecsJars"
    - iip-ecs.service (with dependency to platform.service) as well as ecs-noDeps.service (for standalone 
      device installation) for Linux/systemd and JDK > 8, ecs8.service for Linux/system and JDK 8
  - The service manager
    - serviceMgr.bat for Windows and JDK > 8 and JDK <= 13, serviceMgr8.bat for Windows and JDK 8
    - serviceMgr.sh for Linux/Bash and JDK > 8 and JDK <= 13, serviceMgr8.sh for for Linux/Bash and JDK 8
    - source code in "serviceMgr"
    - binaries in "svcJars"
    - iip-serviceMgr.service (with dependency to ecs.service) as well as serviceMgr-noDeps.service (for standalone 
      device/container installation) for Linux/systemd and JDK > 8 and JDK <= 13, akin serviceMgr8.service and 
      serviceMgr8-noDeps.service for JDK 8
  - For small resources: ECS runtime without container manager but including service manager
    - ecsServiceMgr.bat for Windows and JDK > 8 and JDK <= 13, ecsServiceMgr8.bat for Windows and JDK 8
    - ecsServiceMgr.sh for Linux/Bash and JDK > 8 and JDK <= 13, ecsServiceMgr8.sh for for Linux/Bash and JDK 8
    - source code in "ecsServiceMgr"
    - binaries in "ecsSvcJars"
    - iip-ecsServiceMgr.service for Linux/systemd and JDK > 8, ecsServiceMgr8.service for Linux/system and JDK 8
  - The platform command line 
    - cli.bat for Windows and JDK > 8 and JDK <= 13, cli8.bat for Windows and JDK 8
    - cli.sh for Linux/Bash and JDK > 8 and JDK <= 13, cli8.sh for Linux/Bash and JDK 8
    - source code also in "platform"
    - binaries also in "plJars"
  - The folder "common": 
    - Empty, intended for optimizing installations.
    - Do not delete, the scripts refer to it in case that JARs are in the folder. 
  - The management user interface (Angular)
    - Compiled binaries with instantiated AAS settings in mgtUi
    - mgtUi.bat startup script for Windows (nodeJS 12, Angular 12)
    - mgtUi.sh startup script for Linux (nodeJS 12, Angular 12)
    - iip-mgtUi.service for Linux/systemd
  - The folder "artifacts":
    - Place your application service artifacts, deployment plans (.yml) or containers (with container 
      descriptor, .yml) into this directory. Container and descriptor may be located in individual sub-folders.
    - By default, this folder is is in the folder wher wethe platform is being started from. The folder may 
      also be in a different location (see configuration).

In your platform configuration, consider setting instDir and javaExe to the actual locations in your system. 
Also setup an artifacts folder (artifactsFolder) and a proper artifactsUriPrefix so that downloads form an 
installed webserver or the included express server becomes possible.

For installing the system.d services (all prefixed with iip- to avoid confusion with real system services), 
go as root into /etc/systemd/system and copy (links may not work) each relevant service file on the actual 
machine, e.g., cp /iip/actual/gen/broker/iip-broker.services . 
Call then systemctl daemon-reload, enable the services, e.g., systemctl enable iip-broker.services, 
and start them, e.g., systemctl start iip-broker.services.

