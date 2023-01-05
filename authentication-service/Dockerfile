FROM openjdk:11
COPY target/authentication-service-*.jar  /demo.jar
EXPOSE 9090
# Run the web service on container startup.
CMD java -jar /demo.jar
