FROM openjdk:8-alpine

ARG JAR_FILE
ADD ${JAR_FILE} /customermgmt/api.jar

ENTRYPOINT ["java","-jar","/customermgmt/api.jar"]