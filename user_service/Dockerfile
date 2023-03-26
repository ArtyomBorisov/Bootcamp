FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER Bootcamp

ADD ./target/user_service.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/user_service.jar"]

EXPOSE 8080