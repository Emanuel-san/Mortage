FROM openjdk:18
WORKDIR /app
COPY mortage-1.0-SNAPSHOT.jar mortage-1.0-SNAPSHOT.jar
COPY mortage-1.0-SNAPSHOT-jar-with-dependencies.jar mortage-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY prospects.txt prospects.txt

ENTRYPOINT ["java","-jar", "mortage-1.0-SNAPSHOT-jar-with-dependencies.jar"]