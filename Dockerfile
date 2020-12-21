FROM openjdk:12-alpine
LABEL maintainer="Jaime Junior"
ENV LANG C.UTF-8
ADD target/*.jar /app/app.jar
CMD java -jar /app/app.jar
