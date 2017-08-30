CREATE DATABASE test;
CREATE TABLE $test::pString;
CREATE TABLE ${test::pString + "MyTable"};
${IF test::pBoolean}INSERT INTO TABLE $test::pString${ELSE}DELETE FROM TABLE $test::pString${ENDIF};