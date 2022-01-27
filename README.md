#CouchbaseDemoTodoApp

##Building:

In order to build the app, you need to run `mvn clean install`, this will create a JAR file in the "target" directory.

##Testing:

When you run `mvn clean install`, the tests will run automatically. You need a couchbase server to be able to run tests. In order to mock couchbase server you can use [CouchbaseMock Project](https://github.com/couchbase/CouchbaseMock), further explanation can be found in the project page.

##Running the app:

To be able to run the app, you need a couchbase server. You can use a docker container for that. If you have Docker installed, when you run the command below the couchbase server will be created and started. You can configure the couchbase server from `http://localhost:8091/ui/index.html` and feed your couchbase credential to the project from `application.properties` file.

>docker run -d --name db -p 8091-8096:8091-8096 -p 11210-11211:11210-11211 couchbase

After that you can start the Spring Boot application which was created in the "target" directory (by running `mvn clean install`) via `java -jar <JAR_FILE_NAME>` command.

##Run as Docker Container:

In order to run the project as a docker container, execute the command below in the root directory of the project:

>docker-compose up

This will setup the frontend, the backend and couchbase server. (These three images can be found separately [here](https://hub.docker.com/u/noxob))

##Swagger:

Swagger endpoint is `http://localhost:8080/swagger-ui/` by default.

##Frontend:

Frontend repository can be found [here](https://github.com/Noxob/couchbase-demo-todoapp-ui).

##Containerize:

In order to containerize you need to run `createdockerimages.txt` line by line. This will create a container containing both couchbase server and our backend.

**If you make any changes in `./couchbase-docker-image/configure-server.sh` you can run `./dos2unix.exe ./couchbase-docker-image/configure-server.sh` to prevent any formatting errors from occuring within the container.**
