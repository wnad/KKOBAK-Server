# Build stage
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

# Run stage
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar kkobak-server.jar

ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 환경 변수 설정
ENV KKOBAK_DB_HOST= \
    KKOBAK_DB_PORT= \
    KKOBAK_DB_NAME= \
    KKOBAK_DB_USERNAME= \
    KKOBAK_DB_PASSWORD= \
    KKOBAK_JWT_SECRET_KEY= \
    KKOBAK_JWT_ISSUER= \
    KKOBAK_JWT_EXPIRATION= \
    KKOBAK_SECURITY_NAME= \
    KKOBAK_SECURITY_PASSWORD= \
    KKOBAK_GOOGLE_CLIENT_ID= 

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kkobak-server.jar"] 