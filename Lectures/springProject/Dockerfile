
FROM maven:3-eclipse-temurin-25 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:25-jdk-noble
WORKDIR /app
COPY --from=build /build/target/springProject-0.0.1-SNAPSHOT.jar /app/app.jar
COPY docker-entrypoint.sh /app/docker-entrypoint.sh
RUN sed -i 's/\r$//' /app/docker-entrypoint.sh
ENTRYPOINT ["sh", "/app/docker-entrypoint.sh"]