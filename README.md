# Database

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


GET : http://localhost:8080/messenger/10001/messages
GET : http://localhost:8080/messenger/all

[schema](https://github.com/nitinkc/messenger-spring-boot/blob/master/src/main/resources/schema.sql)

[data.sql](https://github.com/nitinkc/messenger-spring-boot/blob/master/src/main/resources/data.sql)

[Help mySql](https://walkingtechie.blogspot.com/2018/12/execute-schema-and-data-sql-on-startup-spring-boot.html)
