# Regras da Arquitetura Hexagonal - Cinema API

## Estrutura de Camadas

```
┌─────────────────────────────────────────────────────────┐
│                      ADAPTERS                           │
│  ┌─────────────┐                    ┌─────────────┐    │
│  │  Primary    │                    │  Secondary  │    │
│  │(Controllers)│                    │(Repositories)│   │
│  └──────┬──────┘                    └──────┬──────┘    │
│         │ usa                    implementa │          │
├─────────┼───────────────────────────────────┼──────────┤
│         ▼           APPLICATION             │          │
│  ┌─────────────┐                    ┌───────▼─────┐    │
│  │ Input Ports │                    │ Output Ports│    │
│  │ (interfaces)│                    │ (interfaces)│    │
│  └──────┬──────┘                    └─────────────┘    │
│         │                                  ▲           │
│         ▼                                  │ usa       │
│  ┌─────────────────────────────────────────┴─────┐     │
│  │                  USE CASES                    │     │
│  └───────────────────────┬───────────────────────┘     │
├──────────────────────────┼──────────────────────────────┤
│                          ▼         DOMAIN              │
│  ┌─────────────────────────────────────────────────┐   │
│  │     Entities, Value Objects, Enums, Exceptions  │   │
│  └─────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────┘
```

---

## Regras por Camada

### 1. DOMAIN (Núcleo)

**Localização:** `application/domain/`

**Contém:**
- Entities (Client, Movie, Session, Ticket, etc.)
- Value Objects (Address, etc.)
- Enums (AgeRating, Format, Role, SeatType, etc.)
- Domain Exceptions

**Regras:**
- ❌ NÃO depende de nenhuma outra camada
- ❌ NÃO importa classes de Application, Adapters ou Config
- ❌ NÃO usa anotações de framework (JPA, Spring, Lombok, etc.)
- ❌ NÃO conhece como será persistido (sem @Entity, @Id, @Column)
- ❌ NÃO tem dependências externas no pom.xml/build.gradle
- ✅ Contém apenas lógica de negócio pura (POJOs)
- ✅ Pode ser testado sem dependências externas
- ✅ Usa apenas Java puro

---

### 2. APPLICATION (Casos de Uso)

**Localização:** `application/`

**Contém:**
- Input Ports (`ports/in/`) - interfaces que definem os casos de uso
- Output Ports (`ports/out/`) - interfaces para dependências externas
- Use Cases (`usecases/`) - implementações dos Input Ports
- DTOs (`dtos/`) - objetos de transferência de dados
- Validation (`validation/`) - validadores customizados

**Regras:**
- ✅ DEPENDE apenas de Domain
- ❌ NÃO depende de Adapters
- ❌ NÃO conhece implementações concretas de Output Ports
- ✅ Use Cases IMPLEMENTAM Input Ports
- ✅ Use Cases USAM Output Ports (via injeção de dependência)

**Input Ports:**
```java
// Interface definida em Application
public interface CreateMovieUseCase {
    Movie execute(CreateMovieCommand command);
}
```

**Use Case implementa Input Port:**
```java
@Service
public class CreateMovieUseCaseImpl implements CreateMovieUseCase {
    private final MovieRepository movieRepository; // Output Port
    
    @Override
    public Movie execute(CreateMovieCommand command) {
        // Lógica de negócio
    }
}
```

---

### 3. ADAPTERS

**Localização:** `adapters/`

#### 3.1 Primary Adapters (Driving/Entrada)

**Localização:** `adapters/in/`

**Contém:**
- REST Controllers
- GraphQL Resolvers
- CLI Commands
- Message Listeners

**Regras:**
- ✅ USAM Input Ports (chamam métodos)
- ❌ NÃO implementam Input Ports
- ✅ PODEM usar elementos do Domain para:
  - Ler Entities (para montar responses)
  - Usar Enums (para conversão de inputs)
  - Usar Value Objects (para validação)
- ❌ NÃO instanciam Entities
- ❌ NÃO modificam Entities diretamente
- ❌ NÃO contêm lógica de negócio

**Exemplo correto:**
```java
@RestController
public class MovieController {
    private final CreateMovieUseCase createMovieUseCase; // Input Port
    
    @PostMapping("/movies")
    public ResponseEntity<MovieResponse> create(@RequestBody MovieRequest request) {
        // Usa Enum do Domain
        AgeRating rating = AgeRating.valueOf(request.ageRating());
        
        // Chama Use Case via Input Port
        Movie movie = createMovieUseCase.execute(new CreateMovieCommand(...));
        
        // Lê Entity para montar response
        return ResponseEntity.ok(MovieResponse.from(movie));
    }
}
```

#### 3.2 Secondary Adapters (Driven/Saída)

**Localização:** `adapters/out/`

**Contém:**
- Repository Implementations
- External API Clients
- Message Publishers
- Email Services

**Regras:**
- ✅ IMPLEMENTAM Output Ports
- ✅ PODEM instanciar e manipular Entities (para persistência)
- ✅ Convertem entre Domain e infraestrutura

**Exemplo correto:**
```java
@Repository
public class JpaMovieRepository implements MovieRepository { // Implementa Output Port
    private final SpringDataMovieRepository springRepo;
    
    @Override
    public Movie save(Movie movie) {
        MovieEntity entity = MovieEntity.fromDomain(movie);
        return springRepo.save(entity).toDomain();
    }
}
```

---

### 4. CONFIG

**Localização:** `config/`

**Contém:**
- Configurações do Spring
- Beans de infraestrutura
- Security Config

**Regras:**
- ✅ PODE conhecer todas as camadas (é infraestrutura)
- ✅ Responsável por wiring/injeção de dependência
- ❌ NÃO contém lógica de negócio

---

## Tabela de Dependências

| De ↓ / Para → | Domain | Application | Adapters | Config |
|---------------|--------|-------------|----------|--------|
| **Domain**    | ✅     | ❌          | ❌       | ❌     |
| **Application**| ✅    | ✅          | ❌       | ❌     |
| **Adapters**  | ✅ Leitura | ✅ Via Ports | ✅   | ❌     |
| **Config**    | ✅     | ✅          | ✅       | ✅     |

---

## Uso do Domain por Adapters

| Elemento Domain | Usar/Ler | Instanciar | Modificar | Implementar/Extender |
|-----------------|----------|------------|-----------|---------------------|
| **Enums**       | ✅       | ✅ (são valores) | N/A   | ❌                  |
| **Value Objects**| ✅      | ⚠️ Simples* | ❌       | ❌                  |
| **Entities**    | ✅       | ❌         | ❌        | ❌                  |
| **Domain Exceptions** | ✅ | ✅ (para lançar) | N/A | ❌               |

*\*VOs simples de conversão (Email, CPF) podem ser instanciados para validação*

---

## Fluxo de uma Requisição

```
1. Request HTTP chega
        ↓
2. Controller (Primary Adapter) recebe
        ↓
3. Controller converte request para Command/DTO
        ↓
4. Controller chama Input Port
        ↓
5. Use Case (implementa Input Port) executa lógica
        ↓
6. Use Case usa Output Port para persistência
        ↓
7. Repository (Secondary Adapter) implementa Output Port
        ↓
8. Use Case retorna Entity
        ↓
9. Controller converte Entity para Response
        ↓
10. Response HTTP retorna
```

---

## Checklist de Validação

### Ao criar uma nova classe, pergunte:

- [ ] **É lógica de negócio pura?** → Domain
- [ ] **É um caso de uso/orquestração?** → Application (Use Case)
- [ ] **É uma interface de entrada?** → Application (Input Port)
- [ ] **É uma interface de saída?** → Application (Output Port)
- [ ] **É implementação de entrada (HTTP, CLI)?** → Adapters/in
- [ ] **É implementação de saída (DB, API)?** → Adapters/out
- [ ] **É configuração de infraestrutura?** → Config

### Ao fazer imports, valide:

- [ ] Domain não importa nada de outras camadas
- [ ] Application não importa nada de Adapters
- [ ] Adapters não importam implementações concretas de outros Adapters
