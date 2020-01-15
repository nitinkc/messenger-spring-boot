## Multiple Profiles

Dev profile has H2 in memory DB for quick testing.

Remove `spring.profiles.active=dev` from application.properties

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
