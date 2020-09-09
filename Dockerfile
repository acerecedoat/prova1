FROM openjdk:8-jdk-alpine

#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring

ENV GITHUB_CLIENT_ID=""
ENV GITHUB_CLIENT_SECRET=""

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["sh", "-c", "java -jar /app.jar -DGITHUB_CLIENT_ID=${GITHUB_CLIENT_ID} -DGITHUB_CLIENT_SECRET=${GITHUB_CLIENT_SECRET}"]
#ENTRYPOINT ["java", "-jar", "/app.jar", "-DGITHUB_CLIENT_ID=${GITHUB_CLIENT_ID}", "-DGITHUB_CLIENT_SECRET=${GITHUB_CLIENT_SECRET}"]


##
## Build command example:
##       [from inner project folder]
##       docker build -t alm/alm-automation-billing .
##
## Ref: https://spring.io/guides/gs/spring-boot-docker/
##
## docker run -d --name santander-billing -p 8080:8080 -e GITHUB_CLIENT_ID=XXXX -e GITHUB_CLIENT_SECRET=XXXX docker.santander.com:5000/santander/alm-automation-billing
##