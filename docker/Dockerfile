FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
#FROM ubuntu:latest
#LABEL authors="sumin"

#ENTRYPOINT ["top", "-b"]


#ddddddd
#FROM maven:4.0-jdk17 AS builder
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME

#COPY build.maven settings.maven ./


# syntax=docker/dockerfile:1
