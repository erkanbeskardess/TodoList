
FROM openjdk:17-jdk-slim


WORKDIR /app

COPY target/TodoList-0.0.1-SNAPSHOT.jar todolist.jar

ENTRYPOINT ["java", "-jar", "todolist.jar"]

EXPOSE 8081