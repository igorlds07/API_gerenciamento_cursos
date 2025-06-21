# 📚 API de Gerenciamento de Cursos

Uma API RESTful desenvolvida em **Java 17 + Spring Boot**, que permite o gerenciamento completo de cursos. O projeto foi desenvolvido como parte de um desafio técnico e simula operações CRUD com filtros por nome e categoria.

---

## 🛠️ Tecnologias utilizadas

- ✅ Java 17
- ✅ Spring Boot 3
- ✅ Spring Data JPA
- ✅ Hibernate
- ✅ Lombok
- ✅ MySQL
- ✅ Maven
- ✅ Postman (para testes)

---

## 📦 Funcionalidades

- ✅ Criar cursos
- ✅ Listar todos os cursos
- ✅ Filtrar cursos por **nome** e/ou **categoria**
- ✅ Atualizar curso por ID
- ✅ Deletar curso por ID
- ✅ Uso de DTOs para segurança e clareza nos dados
- ✅ Mensagens de erro claras em caso de falhas

---

## 🔗 Endpoints da API

> 📍 **Base URL**: `http://localhost:8082/curso`

### 📥 Criar curso
**POST** `/curso`
```json
{
  "nameCurso": "Java na Veia",
  "categoryCurso": "Curso intensivo de Java"
}

📄 Listar todos os cursos
GET /curso

🔍 Filtrar cursos por nome e/ou categoria
GET /curso?name=Java&category=Backend

Ambos os parâmetros são opcionais.

♻️ Atualizar curso
PUT /curso/{id}

json
Copiar
Editar
{
  "nameCurso": "Spring Boot Avançado",
  "categoryCurso": "Back-end"
}
🗑️ Deletar curso
DELETE /curso/{id}

🧰 Como executar localmente
📋 Pré-requisitos
Java 17 instalado

MySQL rodando localmente

Criar banco de dados:
CREATE DATABASE cursos;

Atualizar application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/cursos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

🚀 Rodando o projeto

# Clone o repositório
git clone https://github.com/igorlds07/api-gerenciamento-cursos.git

# Acesse a pasta
cd api-gerenciamento-cursos

# Execute o projeto com Maven
./mvnw spring-boot:run

🧪 Testando com Postman
Você pode importar a collection do Postman e testar os endpoints manualmente.
Recomendo testar:

POST (criação de curso)

GET com e sem filtros

PUT com ID válido

DELETE com ID válido e inválido

🗂️ Estrutura do Projeto

src
├── controller      # Endpoints REST
├── service         # Lógica de negócios
├── repository      # Interface com o banco de dados
├── entity          # Entidades JPA (com anotações)
├── dto             # Data Transfer Objects (request/response)
└── ApiDeCursosApplication.java
