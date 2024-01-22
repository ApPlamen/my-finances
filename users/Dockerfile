FROM eclipse-temurin:21.0.1_12-jdk-alpine as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
ARG DATABASE_URL="jdbc:mysql://host.docker.internal:3307/my_finances_users"
RUN ./mvnw clean install

FROM eclipse-temurin:21.0.1_12-jdk-alpine
WORKDIR /opt/app
ENV DATABASE_URL="jdbc:mysql://host.docker.internal:3307/my_finances_users"
EXPOSE 8082
COPY --from=builder /opt/app/target/my_finances_users_service.jar /opt/app/my_finances_users_service.jar
ENTRYPOINT ["java","-jar","/opt/app/my_finances_users_service.jar"]
