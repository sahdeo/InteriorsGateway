FROM openjdk:11
ADD ./target/designer-service-0.0.1-SNAPSHOT.jar /usr/src/designer-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "designer-service-0.0.1-SNAPSHOT.jar"]
