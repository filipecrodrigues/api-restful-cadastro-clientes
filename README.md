# Cadastro de Clientes - API Spring Boot

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot**,
utilizando **JPA/Hibernate**, **H2 Database**, validações com **Bean
Validation** e documentação automática com **Swagger (OpenAPI 3)**.

------------------------------------------------------------------------

##  1. API é REST ou RESTful?

A API segue todas as boas práticas REST e por isso é considerada
**RESTful**.

------------------------------------------------------------------------

##  Swagger / OpenAPI --- Documentação da API

A documentação da API é gerada automaticamente usando **Springfox
3.0.0**, compatível com Spring Boot 2.2.x.

### ✔ Dependência no `pom.xml`

``` xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

### ✔ Classe de Configuração (`SpringFoxConfig.java`)

``` java
@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.filiperodrigues.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
```

### ✔ Acessar a documentação

Após iniciar o projeto:

    http://localhost:8080/swagger-ui/

ou

    http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------

##  Estrutura do Projeto

    src/main/java/io/github/filiperodrigues/
     ├── config/
     ├── controller/
     ├── entity/
     ├── exception/
     ├── repository/
     └── ClientesApplication.java

------------------------------------------------------------------------

##  Tecnologias Utilizadas

-   Spring Boot 2.2.6
-   Spring Web
-   Spring Data JPA
-   H2 Database
-   Bean Validation
-   Swagger (Springfox 3.0.0)
-   Lombok

------------------------------------------------------------------------

## ▶ Como Executar

### 1️ Clonar o repositório

``` bash
git clone <url-do-repositorio>
cd api-restful-cadastro-clientes
```

### 2️ Rodar o projeto

``` bash
mvn spring-boot:run
```

### 3 Acessar o H2 Console

    http://localhost:8080/h2-console

------------------------------------------------------------------------

##  Endpoints Principais

-   `POST /api/clientes` --- Criar cliente\
-   `GET /api/clientes/{id}` --- Buscar por ID\
-   `PUT /api/clientes/{id}` --- Atualizar\
-   `DELETE /api/clientes/{id}` --- Remover

------------------------------------------------------------------------

## Validações

-   Nome obrigatório\
-   CPF obrigatório\
-   CPF válido via `@CPF`\
-   Mensagens em `messages.properties`

------------------------------------------------------------------------

##  Licença

Uso livre para estudo e projetos pessoais.

------------------------------------------------------------------------

##  Autor

Projeto criado por **Filipe Rodrigues**.
