FROM gcr.io/google-appengine/openjdk
COPY ./build/libs/dso-0.0.1-SNAPSHOT.war /app/

WORKDIR /app
EXPOSE 8080
ENTRYPOINT java -Xmx1024m -XX:MaxMetaspaceSize=100m -jar dso-0.0.1-SNAPSHOT.war