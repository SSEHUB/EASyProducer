# Java Command Line Interface Client

A Java Command Line Interface (CLI) client that users jlxd to communicate with underlying lxd installation

To test, use the CLI:
* [bin/jlxd.sh](https://github.com/digitalspider/jlxd/blob/master/jlxd-cli/bin/jlxd.sh)

This has sample code for how to interact with the LxdServiceImpl:
* [App.java](https://github.com/digitalspider/jlxd/blob/master/jlxd-cli/src/main/java/au/com/jcloud/lxd/App.java)

To use run use [Maven](https://maven.apache.org):
* mvn install
* bin/jlxd.sh

See:
* https://www.stgraber.org/2016/04/18/lxd-api-direct-interaction
* http://www.ubuntu.com/cloud/lxd
* https://linuxcontainers.org/lxd/getting-started-cli
* https://github.com/lxc/lxd/blob/master/doc/rest-api.md
