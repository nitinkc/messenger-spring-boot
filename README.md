# Backend for ToDo App

## Multiple Profiles
Dev profile has H2 in memory DB for quick testing.

Remove `spring.profiles.active=dev` from application.properties


## Circle CI Integration and automatic DockerHub image push via circleCi Builds
Just commit the changes into master branch, and CircleCI will begin the build, and after the build is successful, 
the image is updated on the dockerhub repository. .circleci folder has the config.yml file for the circleci integration.

The $DOCKER_USER and $DOCKER_PASS in your CircleCI configuration are typically environment variables that you should define in your CircleCI project settings or as project-level environment variables.

Here's how you can set them in your CircleCI project settings:

Go to your project's settings on the CircleCI website.
Select "Environment Variables" from the left sidebar.
Click the "Add Environment Variable" button.
Set the name as DOCKER_USER and the value as your Docker Hub username.
Add another environment variable with the name DOCKER_PASS and the value as your Docker Hub password (or an access token if you prefer).


## Database

#### Mac Brew Mysql
```shell script
# Start MySql Server
mysql.server start

# Stop MySql Server
mysql.server startstop
```
 
#### Docker to run the DB

```dockerfile
docker pull mysql

docker run -d --name=mysql_learning --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" -v /Users/nitin/Downloads/docker_data:/var/lib/mysql -p=3306:3306 mysql

# Execute below to run SQL prompt
docker exec -it mysql_learning mysql -uroot -p
```

### Localhost

GET : http://localhost:8080/messenger/10001/messages

GET : http://localhost:8080/messenger/all

[schema](https://github.com/nitinkc/messenger-spring-boot/blob/master/src/main/resources/schema.sql)

[data.sql](https://github.com/nitinkc/messenger-spring-boot/blob/master/src/main/resources/data.sql)

[Help mySql](https://walkingtechie.blogspot.com/2018/12/execute-schema-and-data-sql-on-startup-spring-boot.html)

## AWS Beanstalk 

To work with H2 in memory DB (testing purposes), choose Branch 1-h2-inMemory-db, and do a mvn build package.

On AWS Beanstalk,

All Applications -> messenger-app  

MessengerApp-env  

URL: MessengerApp-env.us56ewjdta.us-east-1.elasticbeanstalk.com 

Following two GET Calls would work:

http://messengerapp-env.us56ewjdta.us-east-1.elasticbeanstalk.com/messenger/all

http://messengerapp-env.us56ewjdta.us-east-1.elasticbeanstalk.com/messenger/10001/messages


## Dockerization

[Dockerfile](https://github.com/nitinkc/messenger-spring-boot/blob/master/Dockerfile)

Spotify, the docker maven plugin to facilitate the dockerization

Run the docker container from local machine

`docker run --publish 8080:5000 -t nitinkc/messenger:0.0.1-SNAPSHOT`

Spring boot on Docker container running on port 5000, mapped with port 8080 of the local machine.

```shell script


```
