@echo off
REM starts the management UI, install nodejs before

cd mgtUi
call npm list express
if errorlevel 1 (
    call npm install express
)
call npm list cors
if errorlevel 1 (
    call npm install cors
)
node server.js %*
