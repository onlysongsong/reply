FROM maven:3.8.1-jdk-8-slim as builder

MAINTAINER song

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# 声明环境变量，这样容器就可以在运行时访问它们
ENV OPENAI_MODEL=gpt-3.5-turbo
ENV OPENAI_API_KEY=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
#ENV ZSXQ_COOKIE=你的星球Cookie
#ENV ZSXQ_GROUP_ID=你的星球id
# 是否只提醒提问者
ENV ZSXQ_SILENCED=true

# Run the web service on container startup.
ENTRYPOINT ["java","-jar","/app/target/reply-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]