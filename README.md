# Forum Hub One Challenge

Um backend REST API desenvolvido em **Java com Spring Boot** que implementa um fórum com autenticação por **JWT**, CRUD de tópicos e endpoints seguros. <br/>
**Challenge desenvolvido para a Formação Backend do Oracle Next Education - ONE - G9**

## 🧠 Visão Geral

Este projeto foi criado como desafio para demonstrar habilidades em:
- Spring Boot
- Segurança com **JWT**
- Banco de dados relacional (MySQL)
- Migrations com Flyway
- Autenticação e autorização
- API RESTful

---

## 🚀 Funcionalidades

✔ Cadastro de usuários com senha criptografada com **BCrypt**  
✔ Login com geração de **JSON Web Tokens (JWT)**  
✔ Endpoints públicos (ex: listar tópicos)  
✔ Endpoints protegidos por token JWT  
✔ Filtros de segurança com Spring Security  
✔ Validação de requests com anotação `@Valid`

---

## 📦 Tecnologias

O projeto utiliza as seguintes tecnologias:

| Tecnologia | Função |
|------------|--------|
| Java 17+ | Linguagem de programação |
| Spring Boot | Framework principal |
| Spring Security | Gestão de autenticação e autorização |
| JWT | Token baseado em JSON para autenticação |
| Flyway | Versionamento de banco com migrations |
| JPA/Hibernate | Persistência de dados |
| MySQL | Banco de dados relacional |
| Maven | Gerenciamento de dependências |

---

## 🗃️ Estrutura do Projeto

```plaintext
src/
├─ main/
│  ├─ java/
│  │  └─ infra/
│  │     ├─ security/       # TokenService, filters, configs
│  │     └─ domain/         # Entidades e Repositórios
│  └─ resources/
│     ├─ application.properties  # Configs de DB e JWT
│     └─ db/migration/           # Migrations Flyway

```

## 🔒 Segurança

O projeto implementa autenticação com JWT:

1 - O usuário envia um POST para /login com email e senha.

2 - Se a senha for válida, a API retorna um token JWT.

3 - A partir daí, todas rotas protegidas devem incluir o header:

**Authorization: Bearer <TOKEN_JWT>**

O TokenService gera e valida tokens com algoritmo HMAC256 e secret definido em application.properties.

## 🛠 Pré-requisitos

Antes de rodar localmente, instale:

JDK 17 ou superior
Banco SQL (ex: MySQL)
Maven

## 💻 Como Executar

Clone o repositório:

**git clone https://github.com/KaueSiqueira54/forum_hub_one_challenge.git**

Configure o banco no application.properties:

**spring.datasource.url=jdbc:mysql://localhost:3306/forum <br/>
spring.datasource.username=root <br/>
spring.datasource.password=senha <br/>
hub_one.security.token.secret=SEU_SECRET** <br/>

Execute:

**mvn spring-boot:run**

## 📄 Endpoints Importantes

**🔐 Autenticação**

**POST /login**


Body:

{
  "login": "seu@email",
  "senha": "123456"
}


Retorna:

{
  "token": "eyJhbGciOiJIUz..."
}

## 📣 Exemplo de rota pública

**GET /topicos**

## 📁 Banco de Dados

As migrations com Flyway incluem a tabela de usuários, tópicos e relacionamentos necessários.
Senhas são armazenadas como hashes BCrypt.

## 📌 Observações

Senhas não são armazenadas em texto claro (só como hash BCrypt). <br/>
Issuer do JWT deve ser consistente entre geração e validação. <br/>
Rotas seguras exigem token válido. <br/>

## 🧑‍💻 Quem Contribuiu

**Kaue Siqueira – Autor principal**
