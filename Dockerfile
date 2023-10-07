FROM khipu/openjdk17-alpine:latest
ADD target/client-1.0-SNAPSHOT.jar my-maven-docker-project.jar
CMD ["java", "-jar", "my-maven-docker-project.jar"]
