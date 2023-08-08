FROM eclipse-temurin:17-jdk-alpine
COPY target/demoSpring-0.0.1-SNAPSHOT.jar demoSpring-0.0.1-SNAPSHOT.jar
COPY src/main/resources/images/ src/main/resources/images/
ENTRYPOINT ["java","-jar","/demoSpring-0.0.1-SNAPSHOT.jar"]