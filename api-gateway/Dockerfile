FROM openjdk:11
ADD ./target/api-gateway.jar /usr/src/api-gateway.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "api-gateway.jar"]
