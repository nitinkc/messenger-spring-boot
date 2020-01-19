FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/*.jar app.jar
RUN docker pull mysql
RUN docker run -d --name=mysql_learning --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" -p=3306:3306 mysql
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]