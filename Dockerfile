FROM maven:3-openjdk-8 AS builder
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /root
COPY --from=builder /usr/src/app/target .
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]