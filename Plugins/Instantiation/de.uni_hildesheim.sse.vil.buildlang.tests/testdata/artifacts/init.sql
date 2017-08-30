CREATE DATABASE test;
CREATE TABLE $test::pString;
CREATE TABLE ${test::pString + "MyTable"};
${IF test::pBoolean}INSERT INTO TABLE $test::pString${ELSE}DELETE FROM TABLE $test::pString${ENDIF};
SELECT FROM TABLE $pString WHERE column="\$1";
${VAR tName = test::pString}
SELECT FROM TABLE $tName WHERE column="\$1" and TRUE;
${IF not(test::pBoolean)}INSERT INTO TABLE $test::pString;${ENDIF}