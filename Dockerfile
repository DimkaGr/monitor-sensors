FROM amazoncorretto:21

WORKDIR /app

COPY target/monitor-sensors.jar monitor-sensors.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "monitor-sensors.jar"]