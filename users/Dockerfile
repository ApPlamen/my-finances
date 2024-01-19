FROM openjdk:21 as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM openjdk:21
WORKDIR /opt/app
EXPOSE 8082
COPY --from=builder /opt/app/target/my_finances_users_service.jar /opt/app/my_finances_users_service.jar
ENTRYPOINT ["java","-jar","/opt/app/my_finances_users_service.jar"]
