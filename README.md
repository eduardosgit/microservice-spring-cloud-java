# 📘 Microserviço POC — Java 21 + Spring Boot 3.5.14

Este repositório contém uma poc de um microserviço desenvolvido com foco em **aprendizagem**, utilizando tecnologias modernas do ecossistema Java e Spring.  
O objetivo é demonstrar boas práticas de estruturação com arquitetura em camadas, testes, persistência e conteinerização.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.14**
- **Maven**
- **Spring Data JPA**
- **MySQL**
- **Testcontainers**
- **Lombok**
- **Docker Compose**

---

## 📂 Estrutura do Projeto

```text
src/
 ├── main/
 │    ├── java/com/estudo/springservice
 │    │      ├── resources
 │    │      ├── services
 │    │      ├── repositories
 │    │      ├── domain
 │    │      └── exception
 │    │             └── handler
 │    │  
 │    └── resources
 │           └──  application.yml
 │           
 └── test/
      └── java/com/estudo/springservice
             ├── integration
             └── TestcontainersConfig.java
```
---
## 📡 Endpoints (exemplo)

| Método | Rota | Descrição              |
|--------| --- |------------------------|
| GET    | ``/persons`` | Lista todas as pessoas |
| POST   | ``/persons`` | Cria uma nova pessoa   |
| GET    | ``/persons/{id}`` | Busca pessoa por ID    |
| PUT    | ``/persons/{id}`` | Atualiza pessoa por ID |
| DELETE | ``/persons/{id}`` | Deleta pessoa por ID   |

---

## 📘 Aprendizados Esperados

- Configuração de microserviços com Spring Boot 3+
- Uso de Java 21 e recursos modernos
- Persistência com JPA e banco relacional
- Testes reais com Testcontainers
- Conteinerização e orquestração local com Docker Compose
- Boas práticas de arquitetura e modularização