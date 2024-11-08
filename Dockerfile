FROM maven:3-amazoncorretto-17-alpine AS builder

WORKDIR /app

COPY . .

RUN mvn clean package

FROM amazoncorretto:17-alpine AS runner

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
