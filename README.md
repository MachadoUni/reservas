# SalaLivre - API (Back-end)

  

Este repositório contém a API RESTful do **SalaLivre**, um sistema de gerenciamento e reserva de salas para instituições acadêmicas. O back-end é responsável por gerenciar as regras de negócio, autenticação e persistência de dados.

Por enquanto, apenas funções de cadastro de *Salas* e suas *Especificações* estão disponíveis, porém há planos para cadastro de usuários, autenticação, reservas (a parte "principal") e mais.

O front-end dessa aplicação pode ser encontrado em [aqui](https://github.com/MachadoUni/FrontEnd-SalaLivre).

  

## 🚀 Tecnologias Utilizadas

  

*  **Java**

*  **Spring Boot** (Web, Data JPA)

*  **Spring Security** (Controle de acesso e CORS)

*  **Banco de Dados** (H2 Database para desenvolvimento / PostgreSQL para produção)

*  **Maven** (Gerenciamento de dependências)

  

## ⚙️ Como executar o projeto localmente

  

### Pré-requisitos

* Java 17 ou superior instalado.

* Maven instalado (ou utilize o *wrapper*  `./mvnw` incluso no projeto).

  

### 1. Clone o repositório:
Na pasta onde deseja clonar o projeto:
```bash
git clone https://github.com/MachadoUni/reservas.git
```

### 2. Acesse a pasta do projeto:
Na mesma linha de comando:
```bash
cd reservas
```

### 3. Execute o projeto utilizando Maven:
```bash
mvn spring-boot:run
```
### 4. Mapeamentos padrão:
O console do banco de dados pode ser encontrado em http://localhost:8080/h2-console e pode ser acessado com os dados:
* Driver Class: ``org.h2.Driver``
* JDBC URL: ``jdbc:h2:mem:testdb``
* User Name: ``sa``