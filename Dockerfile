FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/User_Service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8100
ENV JAVA_OPTS=""
RUN sh -c "touch User_Service-0.0.1-SNAPSHOT.jar"
ENTRYPOINT [ "java", "-jar", "User_Service-0.0.1-SNAPSHOT.jar" ]
