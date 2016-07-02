# Spring Boot Application with oAuth2.0

This project contains

- Spring Boot 
- Spring  oAuth2.0
- Spring Security



# Running

    - You can run this project from the command-line from the root directory(web-service) of project:
    $ gradle build
    $ java -jar build/libs/app-1.0-SNAPSHOT.jar
   

   - This command creates in memory H2 database and tables with seed data and run application on embedded Jetty server.



    - After startup, your instance will be available on localhost, port 8080.
 
     http://localhost:8080/web/login
     http://localhost:8080/web/register
     http://localhost:8080/web/hello


    - To open H2 console here
    http://localhost:8080/h2-console
  




# Curl Commands

      - Register user
      
      curl -X POST --header "Content-Type: application/json" --header "Accept: text/plain" -d '{ "authorities": [ "ROLE_ADMIN"], "activated": "true", "login" : "admin", "password":"admin", "email":"v@v.com", "langKey":"en"  }' http://localhost:8080/api/register -v
      
   
      - Get user
      
      curl -X GET --header "Accept: application/json" --header "Authorization: Bearer 268b9de3-17b0-4840-8250-14ee066143f2" "http://127.0.0.1:8080/api/users/admin"
      
   
      - isAuthenticated
     
      curl -X GET --header "Accept: application/json" --header "Authorization: Bearer 268b9de3-17b0-4840-8250-14ee066143f2" "http://127.0.0.1:8080/api/authenticate" -v
      

      -  oauth/token
 
      curl -X POST --header "Authorization: Basic dW5pY29ybmFwcDpteVNlY3JldE9BdXRoU2VjcmV0"  -d '{"username" : "admin", "password" : "admin", "grant_type" : "password", "scope" : "read write", "client_secret" : "mySecretOAuthSecret", "client_id" : "unicornapp"}' http://127.0.0.1:8080/oauth/token -v
   
   
   
   
   
    



