# Service for aggregating distributed power sources into a single cloud-based energy provider.

## BUILD && RUN
### Using Commandline:
1. #### Dependency:
    - java 11
    - Maven
2. #### Build and Run
   ```aidl
   mvn clean package
   java -jar target/power-source-0.0.1-SNAPSHOT.jar
   ```
3. #### Access Endpoint Documentation
    - Check http://localhost:8080/swagger-ui.html on browser

### Alternative: Using **Docker**
1. run test cases and build jar file
    1. run below command in project root directory
   ```aidl
   docker run -it --rm --name power-source-service-build -v "$(pwd)":/root -w /root adoptopenjdk/maven-openjdk11:latest mvn clean package
   ```
    2. this will build jar file ``power-source-0.0.1-SNAPSHOT.jar`` in `target` directory
2. Build Docker image using provided `Dockerfile`
    1. run below command in project root directory
   ```aidl
   sudo docker build -t power-source:latest .
   ```
3. Start the application
    1. Run below command in project root directory
   ```aidl
   sudo docker run -d -p 8080:8080 -t power-source:latest
   ```
    2. This start the application in 8080 port
4. Check http://localhost:8080/swagger-ui.html on browser for endpoint documentation and api testing.


## Further Improvement:
- Add Version control for database using Flyway or Liquibase
- Enable Spring boot actuator Prommetheus endpoint for Monitoring

