FROM java:8
RUN mkdir -p /app
COPY build/libs /app
WORKDIR /app
CMD ["java", "-jar" , "rancher-helloworld.jar"]