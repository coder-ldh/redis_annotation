FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8

WORKDIR /tmp/flower


ADD pom.xml /tmp/build/

ADD src /tmp/build/src

RUN cd /tmp/build && mvn clean package \
        #拷贝编译结果到指定目录
        && mv target/*.jar /tmp/flower/app.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build

COPY ./target/*.jar app.jar
ENV LANG='C.UTF-8' LC_ALL='C.UTF-8' TZ='Asia/Shanghai'

RUN printf "nameserver 8.8.8.8\nnameserver 8.8.4.4\nnameserver 114.114.114.114\n" > /etc/resolv.conf \
    && ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone \
    && cd /tmp/flower && ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]