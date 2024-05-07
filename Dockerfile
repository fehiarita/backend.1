# empacotamento
# FROM openjdk-21.0.2-alpine
# FROM apache-maven-3.9.6
# WORKDIR /app

FROM maven
COPY C:\Users\pc\Documents\GitHub\Navit\backend.1/* /app/

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "/app/myapp.jar"]






