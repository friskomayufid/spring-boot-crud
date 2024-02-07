# User API Spec

## Register User

- Endpoint: POST /api/users

Request Body :

```json
{
  "username": "frisko",
  "password": "frisko",
  "name": "Frisko Mayufid"
}
```

Response Body :
```json
{
  "data" : "OK"
}
```

Response Body (Failed) :
```json
{
  "errors" : "Username must not be blank"
}
```

## Login User
- Endpoint: POST /api/auth/login

Request Body :

```json
{
  "username": "frisko",
  "password": "frisko"
}
```

Response Body :
```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt": 232323233232 //miliseconds
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "Username OR Password is wrong"
}
```

## Get User

- Endpoint: GET /api/users/current
  
Request Header :
- X-API-TOKEN: Token (Mandatory)

Response Body :
```json
{
  "data" : {
    "username" : "frisko",
    "name" : "Frisko Mayufid",
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Unauthorized"
}
```

## Update User
- Endpoint: PATCH /api/users/current

Request Header :
- X-API-TOKEN: Token (Mandatory) 

Request Body :

```json
{
  "name": "Frisko Mayufid", // put if want to update name
  "password": "new password" // put if want to update password
}
```

Response Body :
```json
{
  "data" : {
    "username" : "frisko",
    "name": "Frisko Mayufid"
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" : "Unauthorized"
}
```

## Logout User
- Endpoint: DELETE /api/auth/login

Request Header :
- X-API-TOKEN: Token (Mandatory)

Response Body :
```json
{
  "data" : "OK"
}
```