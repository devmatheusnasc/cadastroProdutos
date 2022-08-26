# cadastroProdutos

Dependecies Maven:

https://mvnrepository.com/artifact/org.springframework/spring-web/5.3.22
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jdbc/2.7.3
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/2.7.3
https://mvnrepository.com/artifact/org.postgresql/postgresql
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/2.7.3
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools/2.7.3
https://mvnrepository.com/artifact/javax.validation/validation-api/2.0.1.Final

#URL do endpoint:

URL: [url base]/api/items/ : Create Cadastros.(POST)
requisição:
{description: string,
value: double,
type: char}

URL: [url base]/api/items/{id} : Lista os Cadastro pelo ID.(GET)

URL: [url base]/api/items/{id}: Atualiza os Cadastro. (PUT)
requisição:
{description: string,
value: double,
type: char}

URL: [url base]/api/items/{id} : Deletar Cadastro. (DELETE)

-----------------------------------------------------------------------------------

URL: [url base]/api/orders/ : Create Pedidos.(POST)
requisição:
{number: integer,
date: timestamp,
percentualDiscount: double}

URL: [url base]/api/orders/{id} : Lista os Pedidos pelo ID.(GET)

URL: [url base]/api/orders/{id}: Atualiza os Pedidos. (PUT)
requisição:
{number: integer,
date: timestamp,
percentualDiscount: double,
totalValue: double}

URL: [url base]/api/orders/{id} : Deletar Pedidos. (DELETE)

---------------------------------------------------------------------------------------
URL: [url base]/api/orders/items/ : Create ItemsPedidos.(POST)
requisição:
{description: string,
value: double,
type: char}

URL: [url base]/api/orders/items/{id} : Lista os ItemsPedidos pelo ID.(GET)

URL: [url base]/api/orders/items/{id}: Atualiza os ItemsPedidos. (PUT)
requisição:
{description: string,
value: double,
type: char}

URL: [url base]/api/orders/items/{id} : Deletar ItemsPedidos. (DELETE)

----------------------------------------------------------------------------------------------




