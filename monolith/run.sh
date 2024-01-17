# Install Maven (assumes Maven is not already installed and a JDK is present)
curl -O https://downloads.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz
tar -xzf apache-maven-3.8.4-bin.tar.gz
export PATH=$PWD/apache-maven-3.8.4/bin:$PATH

# Install project dependencies
mvn install

# Compile the project
mvn compile

# Run the web application (assumes Tomcat is not already installed)
curl -O https://downloads.apache.org/tomcat/tomcat-9/v9.0.62/bin/apache-tomcat-9.0.62.tar.gz
tar -xzf apache-tomcat-9.0.62.tar.gz
cp -R src/main/webapp/* apache-tomcat-9.0.62/webapps/ROOT/
cp src/main/webapp/META-INF/context.xml apache-tomcat-9.0.62/conf/

# Start Tomcat in the background
apache-tomcat-9.0.62/bin/startup.sh &
