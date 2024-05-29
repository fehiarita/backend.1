# pegar o maven
FROM  maven:3.8.6-amazoncorretto-17 AS build

COPY apinew/api/src /app/src
COPY apinew/api/pom.xml /app

WORKDIR /app
# para instalar as dependencias e fazer criar a aplicação
RUN mvn clean install -X

# pegar o jdk
FROM openjdk:17-jdk-alpine

# para copiar o que foi criado dentro da pasta app
COPY --from=build /app/target/spring-boot-2-api-0.0.1-SNAPSHOT.jar  /app/app.jar

WORKDIR /app

EXPOSE 8080
# comando que vão ser executados na inicialização do container
CMD [ "java" ,"-jar", "app.jar" ]