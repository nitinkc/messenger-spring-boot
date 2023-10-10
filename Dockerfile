FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080

 # Needs local machine build completed to have the jar created
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]