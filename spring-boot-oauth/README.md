# Spring Boot Application with oAuth2.0

This project contains

- Spring Boot 
- Spring  oAuth2.0
- Spring Security



# Curl Commands

   
    ```
   - Get user
   
   ```
   curl -X GET --header "Accept: application/json" --header "Authorization: Bearer 268b9de3-17b0-4840-8250-14ee066143f2" "http://127.0.0.1:8080/api/users/admin"
   ```
   isAuthenticated
   
   ```
   curl -X GET --header "Accept: application/json" --header "Authorization: Bearer 268b9de3-17b0-4840-8250-14ee066143f2" "http://127.0.0.1:8080/api/authenticate" -v
   ```
   
   oauth/token
   
   ```
   curl -X POST --header "Authorization: Basic dW5pY29ybmFwcDpteVNlY3JldE9BdXRoU2VjcmV0"  -d '{"username" : "admin", "password" : "admin", "grant_type" : "password", "scope" : "read write", "client_secret" : "mySecretOAuthSecret", "client_id" : "unicornapp"}' http://127.0.0.1:8080/oauth/token -v
   ```
   
   ```
   curl -X POST --header "Content-Type: application/json" --header "Accept: text/plain" -d '{ "authorities": [ "ROLE_ADMIN"], "activated": "true", "login" : "admin", "password":"admin", "email":"v@v.com", "langKey":"en"  }' http://localhost:8080/api/register -v
   ```
   
