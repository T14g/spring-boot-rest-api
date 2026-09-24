# REST with Spring Boot and Java

API REST em **Spring Boot 3.4** (Java 21) para estudar CRUD com JPA e MySQL.

## Stack

- Java 21
- Spring Boot 3.4 (`spring-boot-starter-web`, `spring-boot-starter-data-jpa`)
- MySQL (`mysql-connector-j`)
- Maven

## Camadas

```
Controller  →  HTTP e JSON          (PersonController, GreetingController)
Service     →  regra de negócio     (PersonServices)
Repository  →  persistência JPA     (PersonRepositor)
Model       →  entidade / payload   (Person, Greeting)
Exception   →  404 e 500 em JSON    (ResourceNotFoundException, CustomEntityResponseHandler)
```

`Person` é entidade JPA (`tabela person`). Hibernate cria/atualiza o schema com `ddl-auto: update`.

## Como subir

1. Java 21 e Maven
2. MySQL local com o banco `banco-spring`
3. Configuração (o `application.yml` **não vai para o Git** — tem senha):

```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
```

Ajuste `username` e `password` do MySQL.

4. Rodar:

```bash
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints

### Greeting

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/greeting` | Hello, World! |
| GET | `/greeting?name=John` | Hello, John! |

### Person

JSON no body (POST e PUT), header `Content-Type: application/json`. Dados no body, **não** na query string.

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/person` ou `/person/` | Lista todas as pessoas |
| GET | `/person/{id}` | Busca por id |
| POST | `/person` ou `/person/` | Cria |
| PUT | `/person` ou `/person/` | Atualiza (precisa do `id` no JSON) |
| DELETE | `/person/{id}` | Remove |

Exemplo de body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "address": "New York City, New York, US",
  "gender": "Male"
}
```

PUT inclui o `id`:

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "address": "New York City, New York, US",
  "gender": "Male"
}
```

## Erros

| Situação | HTTP | Formato |
|----------|------|---------|
| Pessoa não encontrada | 404 | `ExceptionResponse` (`timestamp`, `message`, `details`) |
| Demais falhas | 500 | mesmo DTO |
| POST/PUT sem JSON no body | 400 | Problem Detail do Spring (`Failed to read request`) |
| POST/PUT sem `Content-Type: application/json` | 415 | Unsupported Media Type |

`GET /person/{id}` e o PUT disparam `ResourceNotFoundException` quando o id não existe.

## Configuração local

`src/main/resources/application.yml` está no `.gitignore`. O modelo versionado é `application.yml.example`.
