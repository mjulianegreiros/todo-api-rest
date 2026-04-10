# 🚀 Todo List API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-orange)

API REST para gerenciamento de tarefas, desenvolvida como parte dos projetos backend do roadmap.sh.

Este projeto tem como foco a construção de um backend próximo de um ambiente real de produção, aplicando boas práticas como **arquitetura limpa, autenticação com JWT, validação de dados e testes**.

---

## 📌 Funcionalidades

* ✅ Registro de usuários
* 🔐 Autenticação com JWT
* 📝 CRUD completo de tarefas
* 👤 Tarefas vinculadas ao usuário
* ⚠️ Tratamento global de erros
* 📄 Suporte a paginação

---

## 🛠️ Tecnologias

* **Java + Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Spring Security**
* **MySQL**
* **Docker & Docker Compose**
* **JWT (JSON Web Token)**

---

## 📂 Estrutura do Projeto

```
src/main/java/com/example/todo/
├── config/
│   ├── JwtAuthFilter.java
│   └── SecurityConfig.java
├── controllers/
│   ├── TodoController.java
│   └── UserController.java
├── dtos/
│   ├── LoginRequestDTO.java
│   ├── LoginResponseDTO.java
│   ├── TodoRequestDTO.java
│   ├── TodoResponseDTO.java
│   ├── UserRequestDTO.java
│   └── UserResponseDTO.java
├── exceptions/
│   └── GlobalExceptionHandler.java
├── models/
│   ├── Todo.java
│   └── User.java
├── repositories/
│   ├── TodoRepository.java
│   └── UserRepository.java
├── services/
│   ├── JwtService.java
│   ├── TodoService.java
│   └── UserService.java
└── TodoApplication.java
```

---

## ⚙️ Como executar

### 1. Clonar o repositório

```bash
git clone https://github.com/mjulianegreiros/todo-api.git
cd todo-api && cd todo
```

### 2. Subir o banco com Docker

```bash
docker-compose up -d
```

### 3. Rodar a aplicação

```bash
mvn spring-boot:run
```

---

## 🔑 Autenticação

A API utiliza **JWT (JSON Web Tokens)**.

### Registro

```http
POST /register
```

### Login

```http
POST /login
```

O login retorna um token que deve ser enviado nas requisições:

```
Authorization: Bearer <será adicionado posteriormente>
```

---

## 📬 Endpoints da API

### 👤 Usuários

* `POST /register` → Criar novo usuário

### 🔐 Autenticação

* `POST /login` → Autenticar e receber token JWT

### 📝 Tarefas

* `GET /todos` → Listar tarefas do usuário (com paginação)
* `POST /todos` → Criar nova tarefa
* `PUT /todos/{id}` → Atualizar tarefa
* `DELETE /todos/{id}` → Remover tarefa

---

## 🔒 Segurança

* Senhas criptografadas com **BCrypt**
* Autenticação baseada em JWT
* Cada usuário acessa apenas seus próprios dados

---

## 📈 Progresso do Projeto

* 🚧 Em desenvolvimento

---

## 📎 Referência

👉 https://roadmap.sh/projects/todo-list-api

---

## 👨‍💻 Autor

Desenvolvido por Maria Júlia Negreiros

