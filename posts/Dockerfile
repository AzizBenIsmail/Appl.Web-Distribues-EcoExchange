FROM openjdk:11
EXPOSE 8088
ADD target/posts-0.0.1-SNAPSHOT.jar posts.jar
ENTRYPOINT ["java","-jar","posts.jar"]