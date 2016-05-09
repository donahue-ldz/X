#!/bin/ksh
echo ===============================================================================
echo .
echo      Package amsOP
echo .
echo ===============================================================================
cd ..
mvn clean
mvn install -Dmaven.test.skip=true
cd -

echo ===============================================================================
echo .
echo      Install amsOP-biz to local repository
echo .
echo ===============================================================================
cd ../amsOP-web/target/amsOP/WEB-INF/lib
mvn install:install-file -Dfile=amsOP-biz-1.0-SNAPSHOT.jar -DgroupId=com.taobao.amsops -DartifactId=amsOP-biz -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dmaven.test.skip=true
rm ../../../amsOP.war
mv ../../../amsOP ../../../amsOP.war
cd -
