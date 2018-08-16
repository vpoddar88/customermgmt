# Customer Management REST API

This API allows you to manage customers

## Building locally

First you will need to run a maven build, and then create a docker image.
1. mvn clean install
2. docker build --build-arg JAR_FILE=target/api-0.0.1-SNAPSHOT.jar .

Save the image ID for the next section

## Running locally

Use the following command to run the docker image locally

```docker run -e "SPRING_PROFILES_ACTIVE=local" -p 8080:8080 <image id>```

