#!/bin/bash

# .env 파일에서 환경 변수 로드
if [ -f .env ]; then
    export $(cat .env | grep -v '^#' | xargs)
fi

# 프로파일 지정하여 실행
./gradlew bootRun --args='--spring.profiles.active=local' 