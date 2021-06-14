Transfer Service
================

This service is used to transfer funds between two accounts.


Building the project
====================

To build the project run: `mvn clean install`

Running a Spring Boot module
====================
To run the service: `mvn spring-boot:run`
It will  download the embedded mongo database and connect the service on `localhost:27017/transferDB`.
Service will start on port `http://localhost:8080`


#API Specification
###Endpoint
POST [/transfers](#/transfers)

###Sample Input
```json
{
  "sourceAccountNumber": "22222",
  "destinationAccountNumber": "11111",
  "amount": "100.12"
}
```
###Sample Output
```json
{
  "id": "c4e5b313-4624-4b5c-b64f-9e5b94d20f2e",
  "source": {
    "id": "60c7594244386a215f6cfbe6",
    "accountNumber": {
      "value": "22222"
    },
    "balance": {
      "value": 9865.54
    }
  },
  "destination": {
    "id": "60c7594244386a215f6cfbe5",
    "accountNumber": {
      "value": "11111"
    },
    "balance": {
      "value": 10134.46
    }
  },
  "amount": {
    "value": 100.12
  }
}
```
###Note:
Service is configured for two accounts '11111' and '22222' with initial balance of '10000' each.



