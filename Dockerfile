FROM openjdk:8
ADD target/sb-online-0.0.1-SNAPSHOT.jar docker-sbonline-image
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-sbonline-image"]
