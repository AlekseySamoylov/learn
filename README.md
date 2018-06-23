<h1>Docker Spring boot embedded tomcat jar and MongoDB</h1>

<h4>How to start learn with links</h4>
Go to the directory with learn-1.0.jar and Dockerfile 
and execute the following commands:

docker run --name learn-mongo -d -p 27017:27017 mongo

docker build -t learn .

docker run -d -p 8080:8080 --link learn-mongo:mongo learn

<h4>How to start learn with Network</h4>

docker network create backend-network

docker run -d --name=mongo --net=backend-network mongo

docker network create api-network

docker network connect api-network mongo

docker run -d -p 8080:8080 --net=api-network learn

docker network ls

docker network inspect backend-network

// for disconnecting: network disconnect frontend-network learn-mongo

<h4>How to start learn using docker compose</h4>
docker-compose.yml:
<pre>
version: '2'
services:
  learn-api:
    build: .
    links:
      - learn-mongo
    depends_on:
      - learn-mongo
    ports:
      - 8080:8080
  learn-mongo:
    image: mongo:latest
    container_name: "learn-mongo"
    ports:
      - 27017
</pre>

docker-compose up --build -d

docker-compose ps

docker-compose logs

<br/>

docker-compose stop

docker-compose rm

<h4>How to start Learn-project using OpenShift:</h4>
Install MiniShift and execute the following commands:

oc login ${your_minishift_console_url}

oc new-project learn

oc new-app library/mongo --name learn-mongo

oc new-app alekseysamoylov/learn --name learn-api

oc expose svc/learn-api

<h4>Swagger</h4>
UI: localhost:8080/swagger-ui.html

To run Keycloak:
docker run -p 8180:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak

http://info.michael-simons.eu/2017/12/28/use-keycloak-with-your-spring-boot-2-application/


