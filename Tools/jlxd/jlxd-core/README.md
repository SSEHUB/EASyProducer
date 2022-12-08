# Java LXD Rest API Client

A Java API client for LXD (Linux Container Daemon) that allows Java applications to interact with Linux based lxd/lxc commands
To test, use the CLI:
* bin/jlxd.sh

The main interface is here:
* [ILxdService.java](https://github.com/digitalspider/jlxd/blob/master/jlxd-core/src/main/java/au/com/jcloud/lxd/service/ILxdService.java)

Sample code (and the command line interface [jlxd-cli](https://github.com/digitalspider/jlxd/tree/master/jlxd-cli)) is here:
* [App.java](https://github.com/digitalspider/jlxd/blob/master/jlxd-cli/src/main/java/au/com/jcloud/lxd/App.java)

To compile using [Maven](https://maven.apache.org):
* mvn install

See:
* https://www.stgraber.org/2016/04/18/lxd-api-direct-interaction
* http://www.ubuntu.com/cloud/lxd
* https://linuxcontainers.org/lxd/getting-started-cli
* https://github.com/lxc/lxd/blob/master/doc/rest-api.md

Note:
* This now works on a both local and remote LXD instances
* Most GET operations are implemented, but only some of the POST/PUT/DELETE are available
* Cannot create containers from existing images - some things are hard coded here
