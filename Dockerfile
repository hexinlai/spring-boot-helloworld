FROM java:8-alpine
ADD ./target/spring-boot-helloworld.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
