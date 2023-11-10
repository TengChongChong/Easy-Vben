FROM java:8

WORKDIR /easy-vben

ARG JAR_FILE=target/easy-api.jar

COPY ${JAR_FILE} app.jar

EXPOSE 80

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms1024m -Xmx2048m -Djava.security.egd=file:/dev/./urandom"

CMD java $JAVA_OPTS -jar app.jar