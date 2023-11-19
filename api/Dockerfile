FROM openjdk:17-jdk

COPY target/api.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "api.jar"]