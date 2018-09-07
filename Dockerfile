FROM openjdk:8-jdk-alpine

WORKDIR /tmp/flower
COPY ./target/*.jar app.jar
ENV LANG='C.UTF-8' LC_ALL='C.UTF-8' TZ='Asia/Shanghai'

RUN printf "nameserver 8.8.8.8\nnameserver 8.8.4.4\nnameserver 114.114.114.114\n" > /etc/resolv.conf \
    && ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
    && ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]