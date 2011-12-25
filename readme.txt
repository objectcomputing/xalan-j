How to build
------------
First add servlet.jar and ejb.jar to the classpath
./build.sh clean dist

Deploy to the Maven repository
------------------------------
First update the pom files maven/pom-serializer.xml and maven/pom-xalan.xml
maven/deploy.sh

