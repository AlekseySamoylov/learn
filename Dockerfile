FROM maven:3.5.3-jdk-10

USER root

## Install maven
#RUN apk add --no-cache curl tar bash
#ARG MAVEN_VERSION=3.5.3
#ARG USER_HOME_DIR="/root"
#RUN mkdir -p /usr/share/maven && \
#curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
#ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
#ENV MAVEN_HOME /usr/share/maven
#ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
## speed up Maven JVM a bit
#ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
#ENTRYPOINT ["/usr/bin/mvn"]
# ----
# Install project dependencies and keep sources
# make source folder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
# install maven dependency packages (keep in image)
COPY lib /usr/src/app/lib
COPY pom.xml /usr/src/app
COPY src /usr/src/app/src
RUN mvn install:install-file -Dfile=lib/lombok-edge.jar -DgroupId=org.projectlombok -DartifactId=lombok -Dversion=1.16.21 -Dpackaging=jar
RUN mvn -T 1C install && rm -rf target
# copy other source files (keep in image)
RUN mvn package
CMD java -jar target/learn-1.0.jar
