FROM maven:3-eclipse-temurin-17-focal as package
WORKDIR /application
COPY . .
RUN mvn clean package

FROM maven:3-eclipse-temurin-17-focal as builder
WORKDIR /application
COPY --from=package application/target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17
WORKDIR /application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]