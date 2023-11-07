FROM maven:3.8.5-openjdk-18 as build
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -P prod -DskipTests

FROM openjdk:18-oracle
COPY --from=build /app/target/*.jar /app/*.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/*.jar"]