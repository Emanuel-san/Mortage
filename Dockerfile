FROM openjdk:18
WORKDIR /app
COPY mortgage-1.0-SNAPSHOT.jar mortgage-1.0-SNAPSHOT.jar
COPY mortgage-1.0-SNAPSHOT-jar-with-dependencies.jar mortgage-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY prospects.txt prospects.txt

ENTRYPOINT ["java","-jar", "mortgage-1.0-SNAPSHOT-jar-with-dependencies.jar"]