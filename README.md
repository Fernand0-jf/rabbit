# Projeto CRUD REST API

## Tecnologias Usadas

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" width="40"/>  `PostgreSQL`
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" width="40"/>  `Spring Boot 3`
<img src="https://www.vectorlogo.zone/logos/hibernate/hibernate-icon.svg" width="40" height="40">  `Hibernate`
<img src="https://www.svgrepo.com/show/374111/swagger.svg" width="50" height="50">  `Swagger`
<img src="https://raw.githubusercontent.com/projectlombok/lombok/f3a4b1b4151a9dd1646f1b170c17f5f29903f45a/src/installer/lombok/installer/lombok.svg" width="40" height="40">  `Lombok`
<img src="https://ingredient-generation-generated-ingredients.canva.com/1def92e5-cc39-4e53-bb8c-fba023d917a5?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAQYCGKMUHQLRPZXQM%2F20240204%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240204T163812Z&X-Amz-Expires=113218&X-Amz-Signature=e5d4d0dbc68109b1a7e7b13f04b7361e6d0ef872ad02caf74bf6896034beb728&X-Amz-SignedHeaders=host%3Bx-amz-expected-bucket-owner&response-expires=Tue%2C%2006%20Feb%202024%2000%3A05%3A10%20GMT" width="40" height="40">  `Spring Data Jpa`
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40"/>`Java`
## Instruções de Instalação

1. Clone o repositório: `git clone https://github.com/Fernand0-jf/Crud_Rest_Api.git`
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

- `GET /api/funcionarios`: Obter todos os funcionarios
- `GET /api/funcionarios/{id}`: Obter um funcionario específico
- `POST /api/funcionarios`: Criar um novo funcionario
- `PUT /api/funcionarios/{id}`: Atualizar um funcionario existente
- `DELETE /api/funcionarios/{id}`: Excluir um funcionario

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
```
## Deletar Usuário

**Request:**
```http
DELETE /api/usuarios/1
```
**Resposta:**
```http
Funcionario deletado com sucesso.
```
