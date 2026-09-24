# Conceitos do projeto

API REST com Spring Boot 3 (Java 21). Entrada: `Startup` + `@SpringBootApplication`.

## REST e anotações

- `@RestController` — classe que devolve JSON (não página HTML).
- `@RequestMapping` — URL do recurso (`/greeting`, `/person`).
- `@PathVariable` — valor na URL (`/person/1`).
- `@RequestParam` — query string (`/greeting?name=Tiago`).

`GreetingController` usa query param. `PersonController` usa path.

## Dados: record vs classe

| | `Greeting` (record) | `Person` (classe) |
|---|---|---|
| Uso | payload imutável | objeto mutável (setters) |
| Gerado | construtor, getters, equals | você escreve getters/setters |
| Extra | — | `implements Serializable` |

`serialVersionUID` versiona a classe serializável — só no model, não no controller.

## Camadas

```
Controller  →  recebe HTTP, valida, devolve JSON
Service     →  regra de negócio (PersonServices, @Service)
Repository  →  acesso a dados (PersonRepositor)
```

O controller não monta `Person` na mão. Spring injeta o service (`@Autowired` / construtor).

`.gitignore` ignora `target/` (`.class` gerados). O código em `src/` é o que vai para o Git.

## Erros HTTP

1. Exception de negócio (`ResourceNotFoundException` + `@ResponseStatus(NOT_FOUND)`).
2. DTO `ExceptionResponse` (record): timestamp, message, details.
3. `@ControllerAdvice` (`CustomEntityResponseHandler`) converte exception em JSON:
   - `ResourceNotFoundException` → 404
   - demais `Exception` → 500

## Endpoints

- `GET /greeting?name=Tiago`
- `GET /person` e `GET /person/{id}`
- `POST /person` e `PUT /person`
- `DELETE /person/{id}`
