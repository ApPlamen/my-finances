FROM sapmachine:latest as builder
ARG DATABASE_URL
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM sapmachine:latest
WORKDIR /opt/app
EXPOSE 8085
COPY --from=builder /opt/app/target/my_finances_statistics_service.jar /opt/app/my_finances_statistics_service.jar
ENTRYPOINT ["java","-jar","/opt/app/my_finances_statistics_service.jar"]
