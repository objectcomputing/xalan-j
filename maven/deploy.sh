# Script to deploy build output to JBoss Maven repository

# Deploy xalan.jar and source files
mvn org.apache.maven.plugins:maven-deploy-plugin:2.6::deploy-file \
                       -DpomFile=maven/pom-xalan.xml \
                       -Dfile=build/xalan.jar \
                       -Dsources=build/xalan-sources.jar \
                       -DrepositoryId=jboss-releases-repository \
                       -Durl=https://repository.jboss.org/nexus/service/local/staging/deploy/maven2/

# Deploy serializer.jar
mvn org.apache.maven.plugins:maven-deploy-plugin:2.6::deploy-file \
                       -DpomFile=maven/pom-serializer.xml \
                       -Dfile=build/serializer.jar \
                       -Dsources=build/serializer-sources.jar \
                       -DrepositoryId=jboss-releases-repository \
                       -Durl=https://repository.jboss.org/nexus/service/local/staging/deploy/maven2/

# Deploy the full source zip
mvn org.apache.maven.plugins:maven-deploy-plugin:2.6::deploy-file \
                       -DpomFile=maven/pom-xalan.xml \
                       -Dfile=build/xalan-j_2_7_1-src.zip \
                       -Dpackaging=zip \
                       -Dclassifier=source-release \
                       -DrepositoryId=jboss-releases-repository \
                       -Durl=https://repository.jboss.org/nexus/service/local/staging/deploy/maven2/

