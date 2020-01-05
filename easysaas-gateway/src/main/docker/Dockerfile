FROM frolvlad/alpine-oraclejdk8:slim
ADD  bi.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]