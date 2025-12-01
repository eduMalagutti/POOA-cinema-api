# Arquitetura Hexagonal - Cinema API

Este documento descreve a arquitetura hexagonal do projeto Cinema API, definindo as regras e a estrutura para garantir um design desacoplado e manutenível.

## Princípios da Arquitetura Hexagonal

A arquitetura hexagonal, ou arquitetura de Portas e Adaptadores, organiza o código em camadas concêntricas, com as regras de negócio no centro e os detalhes de infraestrutura nas bordas. As dependências sempre apontam para dentro.

- **Domain (Domínio):** O núcleo da aplicação. Contém as entidades, objetos de valor e regras de negócio mais puras. **Não depende de nenhuma outra camada.**
- **Application (Aplicação):** Orquestra os casos de uso da aplicação. Contém a lógica de aplicação que utiliza o domínio para executar tarefas. **Depende apenas do Domínio.**
- **Adapters (Adaptadores):** A camada mais externa. Conecta a aplicação com o mundo exterior (UI, banco de dados, serviços externos). A comunicação com a camada de Aplicação ocorre exclusivamente por meio de **Portas**.

## Estrutura de Módulos

O projeto é dividido nos seguintes módulos principais, que refletem as camadas da arquitetura:

```
cinema-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/ufscar/pooa/cinema_api/
│   │   │       ├── domain/      # Camada de Domínio
│   │   │       ├── application/ # Camada de Aplicação
│   │   │       └── adapters/    # Camada de Adaptadores
│   │   └── resources/
│   └── test/
└── gemini.md
```

## Regras de Dependência

1.  **`domain` não pode depender de nenhum outro módulo.**
    - Contém apenas classes POJOs (Plain Old Java Objects), enums e exceções de domínio.
    - Nenhuma anotação de framework (ex: `@Entity`, `@Service`) é permitida aqui.

2.  **`application` depende apenas de `domain`.**
    - Define as **Portas** (interfaces) para os casos de uso (Input Ports) e para a infraestrutura (Output Ports).
    - Contém as implementações dos casos de uso (Services), que orquestram a lógica de negócio.
    - Utiliza as entidades do `domain` para realizar as operações.

3.  **`adapters` depende de `application`.**
    - **Adaptadores de Entrada (Driving Adapters):** Conectam o mundo externo à aplicação. Ex: Controllers REST. Eles **usam** as `Input Ports` da camada de `application`.
    - **Adaptadores de Saída (Driven Adapters):** Implementam as `Output Ports` para se comunicar com serviços externos. Ex: Repositórios de banco de dados, clientes de outras APIs. Eles **implementam** as `Output Ports` da camada de `application`.

## Fluxo de uma Requisição

1.  Um **Controller** (`adapters.in`) recebe uma requisição HTTP.
2.  O Controller chama um método em uma **Input Port** (interface) na camada `application`.
3.  A implementação do caso de uso (`application.usecase`) é executada.
    - Ela utiliza entidades do `domain` para aplicar as regras de negócio.
    - Se precisar de dados externos (ex: buscar um usuário no banco), ela chama um método em uma **Output Port** (interface).
4.  Um **Adaptador de Saída** (`adapters.out`), como um Repositório, implementa a `Output Port` e realiza a operação de infraestrutura (ex: consulta ao banco de dados).
5.  O resultado é retornado ao longo do mesmo caminho, com o Controller finalmente enviando a resposta HTTP.

Este arquivo servirá como um guia para todos os desenvolvedores do projeto, garantindo que a arquitetura se mantenha consistente e limpa.
