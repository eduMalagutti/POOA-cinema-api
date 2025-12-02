# Regras da Arquitetura Hexagonal (Ports and Adapters)

Este documento descreve as regras fundamentais para a implementação da Arquitetura Hexagonal (também conhecida como Ports and Adapters) neste projeto, otimizado para a compreensão e aplicação com ferramentas como Gemini. O objetivo é garantir um design desacoplado, testável e manutenível.

## Princípios Chave

A arquitetura hexagonal isola a lógica de domínio central de detalhes técnicos externos, como bancos de dados, interfaces de usuário e outros serviços. O "core" da aplicação (Domínio e Aplicação) permanece independente, comunicando-se com o mundo exterior através de "Ports" (portas) que são implementadas por "Adapters" (adaptadores).

## Estrutura de Módulos

### 1. Domínio (Domain)

- **Propósito:** Contém a lógica de negócio essencial, entidades, objetos de valor e regras de negócio.
- **Dependências:**
    - **NÃO DEVE** depender de nenhum outro módulo (nem mesmo `Application`).
    - É o coração da aplicação, independente de como ela é usada ou como os dados são persistidos.
- **Interação:** Define interfaces (ports de saída) para o que precisa do mundo exterior, mas não sabe quem ou como essas interfaces serão implementadas.

### 2. Aplicação (Application)

- **Propósito:** Contém a orquestração da lógica de negócio, casos de uso (use cases), e coordena as interações entre o domínio e os adaptadores.
- **Dependências:**
    - **DEVE** depender APENAS de `Domain`.
    - Nenhuma dependência direta de `Adapters`.
- **Interação:** Define interfaces (ports de entrada) que a UI ou outros sistemas externos usarão para interagir com a aplicação. Utiliza os ports de saída definidos em `Domain` para interagir com serviços externos.

### 3. Adaptadores (Adapters)

- **Propósito:** Conecta o core da aplicação (Domínio e Aplicação) a tecnologias externas, como bancos de dados, frameworks web, sistemas de mensagens, UIs, etc.
- **Dependências:**
    - **DEVE** se comunicar com o módulo `Application` **EXCLUSIVAMENTE** por meio do uso e implementação de `Ports` (interfaces) definidos em `Application` ou `Domain`.
    - Podem depender e utilizar o módulo `Domain` (classes, enums, etc.) para trabalhar com os objetos de domínio (ex: mapear entidades de persistência para objetos de domínio).
    - **NÃO DEVE** implementar, estender ou instanciar classes diretamente de `Domain` ou `Application` (exceto para implementar as interfaces de ports). O relacionamento é sempre de dependência unidirecional (`Adapters` -> `Application`/`Domain`).
- **Tipos:**
    - **Adaptadores de Entrada (Driving Adapters):** Implementam os ports de entrada definidos em `Application`. Ex: Controladores REST, Consumers de mensagens.
    - **Adaptadores de Saída (Driven Adapters):** Implementam os ports de saída definidos em `Domain` (e/ou `Application`). Ex: Repositórios JPA, Clientes de API externa.

## Resumo das Regras de Dependência:

- **Domain:** Independente. Não depende de nenhum outro módulo.
- **Application:** Depende apenas de `Domain`.
- **Adapters:**
    - Dependem de `Application` (via ports) e `Domain`.
    - Não podem ser dependidos por `Application` ou `Domain`.
    - A comunicação com `Application` deve ser via `Ports`.

Ao seguir estas regras, garantimos que a lógica de negócio principal permaneça limpa, testável e portátil, desacoplada das preocupações tecnológicas e de infraestrutura.