#!/bin/bash
# starts the management UI, install nodejs and express before

cd mgtUi
npm list express || npm install express
npm list cors || npm install cors
nodejs server.js $*
