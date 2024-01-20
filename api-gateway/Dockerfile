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
ENV USER_SERVICE_URL="http://host.docker.internal:8083/api/"
COPY --from=builder /opt/app/target/my_finances_api_gateway.jar /opt/app/my_finances_api_gateway.jar
ENTRYPOINT ["java","-jar","/opt/app/my_finances_api_gateway.jar"]
