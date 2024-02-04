# Projeto CRUD REST API com Spring Boot

Uma API RESTful CRUD construída com Spring Boot, Spring Data, Hibernate, Swagger, Lombok e PostgreSQL.
##Tecnologias Usadas
User
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" width="40"/>  `PostgreSQL`
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" width="40"/>  `Spring Boot 3`
<img src="https://www.vectorlogo.zone/logos/hibernate/hibernate-icon.svg" width="40" height="40">  `Hibernate`
<img src="https://www.svgrepo.com/show/374111/swagger.svg" width="50" height="50">  `Swagger`
<img src="https://raw.githubusercontent.com/projectlombok/lombok/f3a4b1b4151a9dd1646f1b170c17f5f29903f45a/src/installer/lombok/installer/lombok.svg" width="40" height="40">  `Lombok`
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) <i class="devicon-spring-plain"></i>

## Instruções de Instalação

1. Clone o repositório: `git clone https://github.com/seu-usuario/seu-projeto.git`
2. Configure o banco de dados PostgreSQL e atualize as configurações no arquivo `application.properties`.
3. Instale as dependências: `mvn install` ou `./gradlew build`
4. Execute a aplicação: `mvn spring-boot:run` ou `./gradlew bootRun`

## Configuração da API

- Certifique-se de configurar corretamente o arquivo `application.properties` com as credenciais do banco de dados PostgreSQL.
- Você pode ajustar outras configurações no arquivo para atender às suas necessidades específicas.

## Documentação da API com Swagger

Acesse a documentação da API utilizando Swagger:

-verifique se está com host e a porta certa ex: http://host:port/swagger-ui.html
- [Swagger UI](http://localhost:8080/swagger-ui.html): Visualize e teste as endpoints da API.

## Uso da API

- Utilize o Postman ou qualquer outra ferramenta para realizar requisições HTTP para as seguintes rotas:

### Rotas da API

- `GET /api/funcionarios`: Obter todos os usuários
- `GET /api/funcionarios/{id}`: Obter um usuário específico
- `POST /api/funcionarios`: Criar um novo usuário
- `PUT /api/funcionarios/{id}`: Atualizar um usuário existente
- `DELETE /api/funcionarios/{id}`: Excluir um usuário

### Exemplos

#### Criar um Novo Usuário

**Request:**
```http
POST /api/usuarios
Content-Type: application/json

{
  "primeiroNome": "John",
  "ultimoNome":"Doe"
  "email": "john@example.com"
}
```
**Resposta:**
```http
{
  "id":1
  "primeiroNome": "John",
  "ultimoNome":"Doe"
  "email": "john@example.com"
}
```

#### Atualizar um Novo Usuário

**Request:**
```http
PUT /api/usuarios/1
Content-Type: application/json

{
  "primeiroNome": "alan",
  "ultimoNome":"alves"
  "email": "john@example.com"
}
```
**Resposta:**
```http
{
  "id":1
  "primeiroNome": "alan",
  "ultimoNome":"alves"
  "email": "john@example.com"
}
```
#### Obter todos os Usuários

**Request:**
```http
GET /api/usuarios
```
**Resposta:**
```http
{
  "id":1
  "primeiroNome": "alan",
  "ultimoNome":"alves"
  "email": "john@example.com"
}
#### Obter todos os Usuários

**Request:**
```http
DELETE /api/usuarios
```
**Resposta:**
```http
Funcionario deletado com sucesso.
```
