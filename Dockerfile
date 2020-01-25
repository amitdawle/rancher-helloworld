FROM java:8  
COPY build/libs /var/www/java
WORKDIR /var/www/java  
CMD ["java", "-jar" , "rancher-helloworld-latest.jar"]