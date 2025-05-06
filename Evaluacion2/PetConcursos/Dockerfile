
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/actividad1-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_X34ARKVFIW6LWMQC /app/wallet
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
