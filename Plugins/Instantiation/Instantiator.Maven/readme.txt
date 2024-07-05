Updating Maven:
  - remove all files from lib (may be keep plexus-classworlds if version did not change over maven)
  - copy new files from maven dist 
  - Execute "dir /B > ..\dir.list" in lib
  - Ensure that all new files are in build.properties
  