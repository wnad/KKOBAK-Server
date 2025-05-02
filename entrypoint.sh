#!/bin/bash

# 시크릿 디렉토리 확인
if [ ! -d "/run/secrets" ]; then
    echo "Error: /run/secrets directory does not exist"
    exit 1
fi

# 환경변수 설정
echo "=== Setting environment variables from secrets ==="
for secret in /run/secrets/*; do
    if [ -f "$secret" ]; then
        secret_name=$(basename "$secret")
        secret_value=$(cat "$secret")
        export "$secret_name"="$secret_value"
        echo "Set $secret_name"
    else
        echo "Warning: $secret is not a file"
    fi
done

# 필수 환경변수 확인
required_vars=(
    "KKOBAK_DB_HOST"
    "KKOBAK_DB_PORT"
    "KKOBAK_DB_NAME"
    "KKOBAK_DB_USERNAME"
    "KKOBAK_DB_PASSWORD"
    "KKOBAK_JWT_SECRET_KEY"
    "KKOBAK_JWT_ISSUER"
    "KKOBAK_JWT_EXPIRATION"
    "KKOBAK_SECURITY_NAME"
    "KKOBAK_SECURITY_PASSWORD"
    "KKOBAK_GOOGLE_CLIENT_ID"
)

echo "=== Checking required environment variables ==="
missing_vars=0
for var in "${required_vars[@]}"; do
    if [ -z "${!var}" ]; then
        echo "Error: Required environment variable $var is not set"
        missing_vars=1
    fi
done

if [ $missing_vars -eq 1 ]; then
    echo "Error: Some required environment variables are missing"
    exit 1
fi

# Spring Boot 실행
echo "=== Starting Spring Boot ==="
exec java -jar /app/kkobak-server.jar