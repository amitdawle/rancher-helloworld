FROM java:8  
COPY . /var/www/java  
WORKDIR /var/www/java  
RUN javac HelloDocker.java  
CMD ["java", "HelloDocker"]  