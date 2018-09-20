FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8

WORKDIR /tmp/flower


ADD pom.xml /tmp/build/

ADD src /tmp/build/src

RUN cd /tmp/build && mvn clean package -Dmaven.test.skip=true \
        #拷贝编译结果到指定目录
        && mv target/*.jar /tmp/flower/app.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build \

ENV LANG='C.UTF-8' LC_ALL='C.UTF-8' TZ='Asia/Shanghai'

RUN cd /tmp/flower