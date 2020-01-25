FROM java:8  
COPY build/classes/main /var/www/java
WORKDIR /var/www/java  
CMD ["java", "com.ad.HelloDocker"]