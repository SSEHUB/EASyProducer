Updating Maven:
  - remove all files from lib (may be keep plexus-classworlds if version did not change over maven)
  - copy new files from maven dist
  - check for plexus-classworlds
  - Execute "dir /B *.jar > ..\dir.list" in lib
  - Ensure that all new files are in build.properties
  - run Main in maven, once with OSGI maven dependency, once without  