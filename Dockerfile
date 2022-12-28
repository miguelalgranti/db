FROM amazoncorretto:11-alpine-jdk

MAINTAINER miguelalgranti

COPY /Users/miguelalgranti/Desktop/db/Dockerfilet/db-0.0.1-SNAPSHOT.jar db-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/db-0.0.1-SNAPSHOT.jar"]