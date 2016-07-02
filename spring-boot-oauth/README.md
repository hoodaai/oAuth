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
      
      curl -X POST --header "Content-Type: application/json" --header "Accept: text/plain" -d '{ "authorities": [ "ROLE_USER"], "activated": "true", "login" : "varunksingh", "password":"password", "email":"v2@v.com", "langKey":"en"  }' http://localhost:8080/api/register -v
     
     
      - Get user details
      
      curl -X GET --header "Accept: application/json" --header "Authorization: Bearer e8e66a54-33c9-46e4-8126-b70dc09d6e66" "http://127.0.0.1:8080/api/users/admin"
      
   
      - check if user is Authenticated
     
      curl -X GET --header "Accept: application/json" --header "Authorization: Bearer 268b9de3-17b0-4840-8250-14ee066143f2" "http://127.0.0.1:8080/api/authenticate" -v
      

      -  Get oauth/token (for OAuth2 client id and secret id see application.yml)
   
       curl -X POST -vu unicornapp:mySecretOAuthSecret http://localhost:8080/oauth/token -H "Accept: application/json" -d "username=admin&password=admin&grant_type=password&scope=read&client_id=unicornapp&client_secret=mySecretOAuthSecret"
      
       curl -X POST  http://localhost:8080/oauth/token -H "Accept: application/json" -d "username=varunksingh&password=password&grant_type=password&scope=read write&client_id=unicornapp&client_secret=mySecretOAuthSecret"




