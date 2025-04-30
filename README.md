
# 📫 API integrada com a busca de CEP

## 🔥 Sobre o Projeto. v1.04.29
- Desenvolvimento de uma API para cadastro de clientes em um DB onde a principal funcionalidade é buscar os dados de localidade apartir do CEP fornecido.
- Este projeto será aplicado em outros projetos futuros que já estão em fase de desenvolvimento.

## 🧠 Funcionalidades

A API permite o cadastro de clientes e buscar de localidade pelo cep:
> ✅ Os dados que estão em ✅ serão salvos no DataBase da API.

Entidade : Address
- ✅ cep
- ✅ Logradouro
- ✅ complemento
- ✅ bairro
- ✅ localidade
- ✅ uf
- ✅ ddd

Entidade : Client
- ✅ id
- ✅ nome
- ✅ Address
---

## 📌 Endpoints da API
A API suporta as seguintes operações:

| Método  | Rota                  | Descrição                  |
|---------|------------------------|----------------------------|
| **GET**    | `/clients`          | Retorna todos os clientes  |
| **GET**    | `/client/find/{id}` | Retorna um client por ID   |
| **POST**   | `/client/register`  | Adiciona um novo cliente   |
| **PUT**    | `/client/updateClient/{id}` | Atualiza um client |
| **DELETE** | `/client/deleteClient/{id}` | Remove um client   |


### 🔎 Exemplo de Requisição `POST` para Criar um CEP

Requisição:
```json
{
  "nome": "Eduardo",
  "address": {
    "cep": "60060440"
  }
}
```

Resposta esperada: 200
```json
{
  "id": 3,
  "nome": "Eduardo",
  "address": {
    "cep": "60060-440",
    "logradouro": "Avenida Almirante Barroso",
    "complemento": "",
    "bairro": "Praia de Iracema",
    "localidade": "Fortaleza",
    "uf": "CE",
    "ddd": "85"
  }
}
```

## 🛠️ Tecnologias Utilizadas

- Java (versão 17)
- Spring Boot
- Banco de dados (DateBase H2 em memória)
- Maven
- Swagger OpenApi (API Documentation)
- API ViaCep (API externa consumida pela aplicação)

---

## 🚀 Melhorias Futuras

- Melhorias no **Swagger(OpenApi)** para documentação interativa da API.
- Autenticação e autorização com **JWT**.
- Deploy da API em um serviço cloud.

---

## 🚀 Como Rodar o Projeto

```bash
- Clone o repositório
git clone https://github.com/seu-usuario/nome-do-repo.git

# Acesse a pasta do projeto
cd nome-do-repo

# Instale as dependências (caso use Maven)
mvn install

# Rode o projeto
mvn spring-boot:run

**link para visualizacao da documentacao: http://localhost:8080/swagger-ui/index.html**


