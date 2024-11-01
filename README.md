Postman

Passo 1: registrar usuario

POST - localhost:8080/auth/register

raw - JSON

{
    "name": "Felipe",
    "email": "felipe.c@gmail.com",
    "password": "123456789"
}

RETORNO: NAME AND TOKEN

---------------------------------------

Passo 2: testar token

GET - localhost:8080/user

AUTORIZATHION do tipo Bearer + token

RETORNO: SUCESSO ou 403

---------------------------------------

Passo 3: login

POST - localhost:8080/auth/login

raw - JSON

{
    "email": "felipe.c@gmail.com",
    "password": "123456789"
}

RETORNO: NAME AND TOKEN
