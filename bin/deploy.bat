@echo off
SET PREV=%CD%
cd ..
call mvn -U -Dmaven.test.skip=true clean package deploy -e
cd %PREV%
pause