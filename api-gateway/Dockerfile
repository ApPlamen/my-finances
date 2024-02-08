FROM sapmachine:latest as builder
ARG USER_SERVICE_URL
ARG FINANCES_SERVICE_URL
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM sapmachine:latest
WORKDIR /opt/app
EXPOSE 8082
COPY --from=builder /opt/app/target/my_finances_api_gateway.jar /opt/app/my_finances_api_gateway.jar
ENTRYPOINT ["java","-jar","/opt/app/my_finances_api_gateway.jar"]
