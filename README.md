# 🎬 POOA Cinema API

Este projeto é parte do trabalho da disciplina de **Programação Orientada a Objetos Avançada (POOA)**.

## 📘 Descrição

API REST para gerenciamento de compra de ingressos em cinemas, desenvolvida com foco em estudos de arquitetura e boas práticas de desenvolvimento.

## 🧱 Arquitetura

* Arquitetura Hexagonal (Ports & Adapters)
* Princípios SOLID
* Padrões de projeto: Singleton, Injeção de Dependência e Inversão de Dependência
* Uso extensivo de interfaces para desacoplamento

## 🚀 Tecnologias Utilizadas

* Java 21
* Apache Maven
* Docker & Docker Compose (para o banco de dados)

## 🛠️ Como Executar o Projeto

### Pré-requisitos

* Java 21 instalado
* Apache Maven instalado
* Docker instalado

### Passos para execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/eduMalagutti/POOA-cinema-api.git
   cd POOA-cinema-api
   ```

2. Inicie o banco de dados com Docker Compose:

   ```bash
   docker-compose up -d
   ```

3. Compile e execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

4. Configure as variáveis de ambiente para email:

   Copie o arquivo `env-example.properties` para `env-dev.properties` e configure as seguintes variáveis com suas credenciais de email:

   ```properties
   EMAIL_HOST=smtp.gmail.com
   EMAIL_PORT=587
   EMAIL_SENDER="MiranhaCar" <your-email>
   EMAIL_USERNAME=your-email
   EMAIL_PASSWORD=your-password
   ```

   **Nota:** O sistema utiliza essas configurações para envio de notificações por email. 
   
   **⚠️ Para Gmail:** O `EMAIL_PASSWORD` deve ser uma **App Password** (Senha de App), não sua senha normal do Gmail. Para gerar uma App Password:
   1. Acesse sua conta Google em [myaccount.google.com](https://myaccount.google.com)
   2. Vá em **Segurança** → **Verificação em duas etapas** (ative se necessário)
   3. Vá em **Senhas de app** e gere uma nova senha para a aplicação
   4. Use essa senha gerada no campo `EMAIL_PASSWORD`

5. Acesse a API em:

   ```
   http://localhost:8080
   ```



## 📂 Estrutura do Projeto

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/ufscar/pooa/cinema_api/
│   │   │           ├── adapters/
│   │   │           │   ├── in/
│   │   │           │   └── out/
│   │   │           ├── application/
│   │   │           │   ├── domain/
│   │   │           │   │   └── enums/
│   │   │           │   ├── dtos/
│   │   │           │   ├── exceptions/
│   │   │           │   ├── ports/
│   │   │           │   │   └── in/
│   │   │           │   ├── usecases/
│   │   │           │   └── validation/
│   │   │           └── config/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
├── docs/
│   └── architecture.dsl
├── docker-compose.yml
├── pom.xml
└── README.md
```



## 🧪 Testes

Para executar os testes automatizados:

```bash
mvn test
```
