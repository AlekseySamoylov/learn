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



