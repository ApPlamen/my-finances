FROM eclipse-temurin:21.0.1_12-jdk-alpine as builder
ARG DATABASE_URL
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:21.0.1_12-jdk-alpine
WORKDIR /opt/app
EXPOSE 8082
COPY --from=builder /opt/app/target/my_finances_users_service.jar /opt/app/my_finances_users_service.jar
ENTRYPOINT ["java","-jar","/opt/app/my_finances_users_service.jar"]
