FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/examen2-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_X34ARKVFIW6LWMQC /app/wallet
COPY src/main/resources/application.properties /app/application.properties
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
