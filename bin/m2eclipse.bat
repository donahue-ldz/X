cd ..
call mvn -U clean eclipse:clean eclipse:m2eclipse -DdownloadSources=true -Dproject.build.sourceEncoding=UTF-8 -e
@pause
