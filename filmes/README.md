# Relatório - Backend Spring Boot (Sistema de Filmes)

## 📋 Informações Gerais

**Projeto:** Sistema de Gerenciamento de Filmes  
**Módulo:** Backend (API REST)  
**Framework:** Spring Boot 3.5.7  
**Linguagem:** Java 21  
**Build Tool:** Maven  
**Banco de Dados:** PostgreSQL (Produção) / H2 (Desenvolvimento)  
**ORM:** JPA/Hibernate  
**Versão:** 0.0.1-SNAPSHOT  
**Data do Relatório:** Dezembro 2025  
**Desenvolvedor:** jhefferson

---

## 1. Visão Geral da Arquitetura

O backend é uma API REST desenvolvida em Spring Boot que fornece os endpoints necessários para gerenciar filmes, usuários, gêneros e avaliações. A arquitetura segue o padrão **MVC (Model-View-Controller)** com separação clara entre camadas.

### Padrão Arquitetural

```
┌─────────────────────────────────────────┐
│        REST Controller Layer            │
│  (ObraController, GeneroController...)  │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Service Layer (Lógica)           │
│  (Business Logic)                       │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Repository Layer (JPA)           │
│  (Data Access)                          │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Model Layer (Entidades)          │
│  (@Entity Classes)                      │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Database (PostgreSQL)            │
│  (Persistência de Dados)                │
└─────────────────────────────────────────┘
```

---

## 2. Dependências Principais

| Dependência | Versão | Função |
|-------------|--------|--------|
| Spring Boot Starter Web | 3.5.7 | REST APIs, Servlets |
| Spring Data JPA | 3.5.7 | Acesso a dados com ORM |
| PostgreSQL JDBC | Latest | Driver para PostgreSQL |
| H2 Database | Latest | BD em memória para testes |
| Lombok | Latest | Geração de getters/setters/construtores |
| SpringDoc OpenAPI | 2.8.13 | Documentação Swagger/OpenAPI |
| Jakarta Persistence | Latest | JPA Annotations |

---

## 3. Estrutura de Diretórios

```
filmes/filmes/
│
├── pom.xml                           # Configuração Maven
├── mvnw / mvnw.cmd                   # Maven Wrapper
├── docker-compose.yml                # Orquestração containers
│
├── src/
│   ├── main/
│   │   ├── java/br/com/jhefferson/filmes/
│   │   │   ├── model/                # Entidades JPA
│   │   │   │   ├── Obra.java         # Modelo de Filme/Obra
│   │   │   │   ├── Usuario.java      # Modelo de Usuário
│   │   │   │   ├── Genero.java       # Modelo de Gênero
│   │   │   │   └── Avaliacao.java    # Modelo de Avaliação/Nota
│   │   │   │
│   │   │   ├── controller/           # REST Controllers
│   │   │   │   ├── ObraController.java        # API de Filmes
│   │   │   │   ├── UsuarioController.java     # API de Usuários
│   │   │   │   ├── GeneroController.java      # API de Gêneros
│   │   │   │   └── AvaliacaoController.java   # API de Avaliações
│   │   │   │
│   │   │   ├── repositorio/          # JPA Repositories
│   │   │   │   ├── ObraRepository.java        # CRUD Obras
│   │   │   │   ├── UsuarioRepository.java     # CRUD Usuários
│   │   │   │   ├── GeneroRepository.java      # CRUD Gêneros
│   │   │   │   └── AvaliacaoRepository.java   # CRUD Avaliações
│   │   │   │
│   │   │   ├── service/              # Serviços (Lógica de Negócio)
│   │   │   │   ├── ObraService.java
│   │   │   │   ├── UsuarioService.java
│   │   │   │   ├── GeneroService.java
│   │   │   │   └── AvaliacaoService.java
│   │   │   │
│   │   │   └── FilmesApplication.java # Classe Principal (Main)
│   │   │
│   │   └── resources/
│   │       ├── application.properties      # Config Padrão (PostgreSQL)
│   │       └── application-dev.properties  # Config Dev (H2 in-memory)
│   │
│   └── test/
│       └── java/br/com/jhefferson/   # Testes Unitários
│
└── target/                           # Artefatos compilados (Maven)
```

---

## 4. Modelos de Dados (Entidades JPA)

### 4.1 Entidade: Obra (Filme)

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/model/Obra.java`

```java
@Entity
@Table(name = "Obra")
public class Obra {
    @Id
    @GeneratedValue
    private Long id;              // ID único (chave primária)
    private String title;         // Título do filme
    private String descrition;    // Descrição/Sinopse
    private Integer anoLancamento; // Ano de lançamento
    private String imagemUrl;     // URL da imagem de capa
    private String tipoObra;      // Tipo (Filme, Série, etc)
    
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;        // Gênero do filme (FK)
}
```

**Campos:**
- `id`: Identificador único (PK, Auto-increment)
- `title`: String - Título do filme
- `descrition`: String - Sinopse/descrição
- `anoLancamento`: Integer - Ano de lançamento
- `imagemUrl`: String - URL da imagem
- `tipoObra`: String - Tipo de obra (Filme, Série, Documentário)
- `genero`: Relação ManyToOne com Genero

**Relações:**
- **Many-to-One com Genero:** Várias obras podem ter o mesmo gênero

---

### 4.2 Entidade: Usuario

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/model/Usuario.java`

```java
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;              // ID único (PK)
    
    @Column(name = "nome", length = 2000, nullable = false)
    private String nome;          // Nome do usuário (obrigatório)
    
    @Column(name = "Gmail")
    private String gmail;         // Email
    
    @Column(name = "sennha")
    private String senha;         // Senha (com typo no BD)
}
```

**Campos:**
- `id`: Identificador único (PK, Auto-increment)
- `nome`: String (Max 2000 chars, NOT NULL) - Nome do usuário
- `gmail`: String - Email do usuário
- `senha`: String - Senha (Note: coluna com typo "sennha")

**Relações:**
- **One-to-Many com Avaliacao:** Um usuário pode ter várias avaliações

---

### 4.3 Entidade: Genero

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/model/Genero.java`

```java
@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;              // ID único (PK)
    private String nome;          // Nome do gênero
}
```

**Campos:**
- `id`: Identificador único (PK, Auto-increment)
- `nome`: String - Nome do gênero (ex: "Ação", "Drama", "Comédia")

**Relações:**
- **One-to-Many com Obra:** Um gênero pode ter várias obras

---

### 4.4 Entidade: Avaliacao (Nota)

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/model/Avaliacao.java`

```java
@Entity
@Table(name = "Avaliaçao")
public class Avaliacao {
    @Id
    @GeneratedValue
    private Long id;              // ID único (PK)
    
    @Column(name = "Nota", nullable = false)
    private String nota;          // Nota/Rating (obrigatório)
    
    private String comentario;    // Comentário da avaliação
    private LocalDateTime data;   // Data/hora da avaliação
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;      // Usuário que fez a avaliação (FK)
    
    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;            // Obra que foi avaliada (FK)
}
```

**Campos:**
- `id`: Identificador único (PK)
- `nota`: String (NOT NULL) - Nota/Rating
- `comentario`: String - Comentário/review
- `data`: LocalDateTime - Data/hora da avaliação
- `usuario`: FK para Usuario
- `obra`: FK para Obra

**Relações:**
- **Many-to-One com Usuario:** Várias avaliações de um usuário
- **Many-to-One com Obra:** Várias avaliações de uma obra

---

## 5. Controllers (API REST)

### 5.1 ObraController (API de Filmes)

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/controller/ObraController.java`

**Base URL:** `/obra`

#### Endpoints Implementados

| Método | Endpoint | Função | Retorno |
|--------|----------|--------|---------|
| GET | `/obra/lista` | Listar todas as obras | `List<Obra>` |
| GET | `/obra/lista/{id}` | Obter obra por ID | `Obra` |
| POST | `/obra/novo` | Criar nova obra | `Obra` |
| PUT | `/obra/atualizar/{id}` | Atualizar obra | `Obra` |

**Exemplos de Requisições:**

```bash
# Listar todas as obras
GET /obra/lista
Response: [
  {
    "id": 1,
    "title": "Avatar",
    "descrition": "Um filme de ficção científica",
    "anoLancamento": 2009,
    "imagemUrl": "https://...",
    "tipoObra": "Filme",
    "genero": { "id": 1, "nome": "Ficção Científica" }
  }
]

# Obter obra específica
GET /obra/lista/1
Response: { "id": 1, "title": "Avatar", ... }

# Criar nova obra
POST /obra/novo
Body: {
  "title": "Novo Filme",
  "descrition": "Descrição...",
  "anoLancamento": 2024,
  "imagemUrl": "...",
  "tipoObra": "Filme",
  "genero": { "id": 1 }
}
Response: { "id": 2, "title": "Novo Filme", ... }

# Atualizar obra
PUT /obra/atualizar/1
Body: { "title": "Avatar Atualizado", ... }
Response: { "id": 1, "title": "Avatar Atualizado", ... }
```

**Código Principal:**

```java
@RestController
@RequestMapping(value = "obra")
public class ObraController {
    @Autowired
    ObraRepository obraRepository;

    @RequestMapping(value = "lista", method = RequestMethod.GET)
    public ResponseEntity<List<Obra>> listar() {
        return ResponseEntity.ok((List<Obra>) obraRepository.findAll());
    }

    @RequestMapping(value = "lista/{id}", method = RequestMethod.GET)
    public ResponseEntity<Obra> getByid(@PathVariable(value = "id") Long id) {
        Optional<Obra> obra = obraRepository.findById(id);
        if(obra.isPresent()) {
            return ResponseEntity.ok(obra.get());
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public ResponseEntity<Obra> novo(@RequestBody Obra obra) {
        return ResponseEntity.ok(obraRepository.save(obra));
    }

    @RequestMapping(value = "atualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Obra> atualizar(@PathVariable(value = "id") Long id, 
                                          @RequestBody Obra novaObra) {
        Optional<Obra> obra = obraRepository.findById(id);
        if(obra.isPresent()) {
            return new ResponseEntity<>(obraRepository.save(novaObra), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
```

---

### 5.2 GeneroController (API de Gêneros)

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/controller/GeneroController.java`

**Base URL:** `/genero`

#### Endpoints Implementados

| Método | Endpoint | Função | Retorno |
|--------|----------|--------|---------|
| GET | `/genero/lista` | Listar todos os gêneros | `List<Genero>` |
| GET | `/genero/listar/{id}` | Obter gênero por ID | `Genero` |
| POST | `/genero/novo` | Criar novo gênero | `Genero` |
| PUT | `/genero/atualizar/{id}` | Atualizar gênero | `Genero` |

**Exemplos:**

```bash
# Listar gêneros
GET /genero/lista
Response: [
  { "id": 1, "nome": "Ação" },
  { "id": 2, "nome": "Drama" }
]

# Criar novo gênero
POST /genero/novo
Body: { "nome": "Ficção Científica" }
Response: { "id": 3, "nome": "Ficção Científica" }

# Atualizar gênero
PUT /genero/atualizar/1
Body: { "nome": "Ação e Aventura" }
Response: { "id": 1, "nome": "Ação e Aventura" }
```

---

### 5.3 AvaliacaoController (API de Avaliações)

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/controller/AvaliacaoController.java`

**Base URL:** `/avaliacao`

#### Endpoints (Padrão CRUD)

- `GET /avaliacao/lista` - Listar avaliações
- `GET /avaliacao/lista/{id}` - Obter avaliação
- `POST /avaliacao/novo` - Criar avaliação
- `PUT /avaliacao/atualizar/{id}` - Atualizar avaliação

---

### 5.4 UsuarioController (API de Usuários)

**Arquivo:** `src/main/java/br/com/jhefferson/filmes/controller/UsuarioController.java`

**Base URL:** `/usuario`

#### Endpoints (Padrão CRUD)

- `GET /usuario/lista` - Listar usuários
- `GET /usuario/lista/{id}` - Obter usuário
- `POST /usuario/novo` - Criar usuário
- `PUT /usuario/atualizar/{id}` - Atualizar usuário

---

## 6. Repositories (JPA)

Os repositories fornecem métodos CRUD automáticos através de Spring Data JPA:

### Interfaces

```java
// ObraRepository
public interface ObraRepository extends JpaRepository<Obra, Long> {}

// UsuarioRepository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}

// GeneroRepository
public interface GeneroRepository extends JpaRepository<Genero, Long> {}

// AvaliacaoRepository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {}
```

### Métodos Automáticos Disponíveis

- `findAll()` - Buscar todos os registros
- `findById(id)` - Buscar por ID
- `save(entity)` - Salvar/Atualizar
- `delete(entity)` - Deletar
- `deleteById(id)` - Deletar por ID
- `existsById(id)` - Verificar existência

---

## 7. Configuração do Banco de Dados

### 7.1 Produção (PostgreSQL)

**Arquivo:** `application.properties`

```properties
spring.application.name=filmes
server.port=8080

# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/filmes
spring.datasource.username=postgres
spring.datasource.password=02022006

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

**Variáveis:**
- `url`: jdbc:postgresql://localhost:5432/filmes
- `username`: postgres
- `password`: 02022006
- `ddl-auto`: update (cria/atualiza tabelas automaticamente)

---

### 7.2 Desenvolvimento (H2 In-Memory)

**Arquivo:** `application-dev.properties`

```properties
spring.application.name=filmes-dev
server.port=8080

# H2 In-Memory Database
spring.datasource.url=jdbc:h2:mem:filmes;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

**Benefícios:**
- BD em memória (não persiste entre reinicializações)
- Ideal para testes rápidos
- Console H2 disponível em `/h2-console`

---

## 8. Docker Compose

**Arquivo:** `docker-compose.yml`

```yaml
services:
  db:
    image: postgres:latest
    container_name: postgres_db
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 02022006
      POSTGRES_DB: filmes
    ports:
      - "5432:5432"
    volumes:
      - ./data:/var/lib/postgresql/data
```

**Como usar:**

```bash
# Iniciar containers
docker-compose up -d

# Parar containers
docker-compose down

# Ver logs
docker-compose logs -f db
```

---

## 9. Build e Deploy

### 9.1 Compilar

```bash
# Compilar código Java
mvn clean compile

# Compilar com skipTests (mais rápido)
mvn clean compile -DskipTests
```

### 9.2 Testes

```bash
# Executar testes
mvn test

# Testes com coverage
mvn test jacoco:report
```

### 9.3 Build (Pacote)

```bash
# Build completo
mvn clean package

# Build sem testes
mvn clean package -DskipTests

# Output: target/filmes-0.0.1-SNAPSHOT.jar
```

### 9.4 Executar

```bash
# Executar JAR
java -jar target/filmes-0.0.1-SNAPSHOT.jar

# Com perfil (profile)
java -jar target/filmes-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

# Com porta customizada
java -jar target/filmes-0.0.1-SNAPSHOT.jar --server.port=9090
```

### 9.5 Desenvolvimento

```bash
# Maven Wrapper (Windows)
mvnw spring-boot:run

# Maven Wrapper (Linux/Mac)
./mvnw spring-boot:run

# Hot Reload (com DevTools)
mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.devtools.restart.enabled=true"
```

---

## 10. Documentação API (Swagger)

### Ativação

Com `springdoc-openapi-starter-webmvc-ui` (versão 2.8.13), o Swagger é automaticamente disponibilizado.

### Endpoints de Documentação

| URL | Função |
|-----|--------|
| `http://localhost:8080/swagger-ui.html` | Interface Swagger UI |
| `http://localhost:8080/v3/api-docs` | JSON da API |
| `http://localhost:8080/v3/api-docs.yaml` | YAML da API |

### Customização

Para adicionar anotações Swagger aos controllers:

```java
@RestController
@RequestMapping("/api/obras")
@Tag(name = "Obras", description = "API para gerenciar obras/filmes")
public class ObraController {
    
    @GetMapping
    @Operation(summary = "Listar todas as obras", description = "Retorna uma lista de todas as obras cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de obras")
    public ResponseEntity<List<Obra>> listar() {
        // ...
    }
}
```

---

## 11. Fluxo de Requisição

```
1. Cliente (Angular/Browser)
   │
   └─→ GET http://localhost:8080/obra/lista
       │
       └─→ ObraController.listar()
           │
           └─→ ObraRepository.findAll()
               │
               └─→ SELECT * FROM Obra
                   │
                   └─→ Database (PostgreSQL)
                       │
                       └─→ [Retorna Lista de Obras]
                           │
                           ├─→ ObraRepository
                           ├─→ ObraController
                           └─→ ResponseEntity<List<Obra>>
                               │
                               └─→ JSON Response (200 OK)
                                   │
                                   └─→ Cliente recebe dados
```

---

## 12. Relatório de Entidades e Relacionamentos

### Diagrama ER (Entity-Relationship)

```
┌─────────────────┐
│    Usuario      │
├─────────────────┤
│ id (PK)         │
│ nome            │ ◄──────┐
│ gmail           │        │
│ senha           │        │
└─────────────────┘        │
                           │ 1:N
                    ┌──────┴─────────┐
                    │                │
            ┌───────▼──────────┐     │
            │   Avaliacao      │     │
            ├──────────────────┤     │
            │ id (PK)          │     │
            │ nota             │     │
            │ comentario       │     │
            │ data             │     │
            │ usuario_id (FK)  |     │
            │ obra_id (FK)     |────┐│
            └──────────────────┘    ││
                                    ││ N:1
                    ┌───────────────┘│
                    │                │
            ┌───────▼──────────┐     │
            │    Obra          │     │
            ├──────────────────┤     │
            │ id (PK)          │     │
            │ title            │     │
            │ descrition       │     │
            │ anoLancamento    │     │
            │ imagemUrl        │     │
            │ tipoObra         │     │_______
            │ genero_id (FK)   ┼───┐        |
            └──────────────────┘   │        |
                                   │ N:1    |
                    ┌──────────────┘        |
                    │                       |
            ┌───────▼──────────┐            |
            │     Genero       │____________|
            ├──────────────────┤
            │ id (PK)          │
            │ nome             │
            └──────────────────┘
```

---

## 13. Testes

### Estrutura de Testes

```
src/test/java/br/com/jhefferson/filmes/
├── controller/
│   ├── ObraControllerTest.java
│   ├── GeneroControllerTest.java
│   ├── AvaliacaoControllerTest.java
│   └── UsuarioControllerTest.java
├── repositorio/
│   ├── ObraRepositoryTest.java
│   ├── GeneroRepositoryTest.java
│   ├── AvaliacaoRepositoryTest.java
│   └── UsuarioRepositoryTest.java
└── FilmesApplicationTests.java
```

### Exemplo de Teste

```java
@SpringBootTest
class ObraControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ObraRepository obraRepository;
    
    @Test
    void testListarObras() throws Exception {
        Obra obra = new Obra();
        obra.setId(1L);
        obra.setTitle("Avatar");
        
        when(obraRepository.findAll()).thenReturn(Arrays.asList(obra));
        
        mockMvc.perform(get("/obra/lista"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].title").value("Avatar"));
    }
}
```

---

## 14. Problemas e Bugs Identificados

### 1. **Typo em Nome de Coluna**
   - **Problema:** `@Column(name = "sennha")` em Usuario
   - **Impacto:** Campo senha tem nome errado no BD
   - **Solução:** Renomear para `"senha"`

### 2. **Typo em Nome de Tabela**
   - **Problema:** `@Table(name = "Avaliaçao")` com acento
   - **Impacto:** Nome de tabela incomum
   - **Solução:** Renomear para `"avaliacao"`

### 3. **Falta de Validação**
   - **Problema:** Sem validações (@Valid, @NotNull, etc)
   - **Impacto:** Dados inválidos podem ser salvos
   - **Solução:** Adicionar Bean Validation

### 4. **Sem Exception Handling**
   - **Problema:** Controllers não tratam exceções
   - **Impacto:** Erros expõem stack trace
   - **Solução:** Implementar @ControllerAdvice

### 5. **Sem CORS Configurado**
   - **Problema:** Frontend Angular não consegue acessar API
   - **Impacto:** Erros CORS em navegador
   - **Solução:** Implementar WebMvcConfigurer com CORS

### 6. **Sem Autenticação/Autorização**
   - **Problema:** Sem Spring Security
   - **Impacto:** API pública e insegura
   - **Solução:** Implementar JWT ou OAuth2

---

## 17. Instruções de Setup Local

### Pré-requisitos
- Java 21+
- Maven 3.8+
- PostgreSQL 12+
- Docker (opcional)

### Setup Passo a Passo

1. **Clonar repositório**
   ```bash
   git clone https://github.com/jheffersonjm/Spring-Bott_E_Angular-Projeto_Filme.git
   cd filmes/filmes
   ```

2. **Instalar dependências Maven**
   ```bash
   mvn clean install
   ```

3. **Configurar banco de dados**
   - Option A: Docker
     ```bash
     docker-compose up -d
     ```
   - Option B: PostgreSQL local
     ```sql
     CREATE DATABASE filmes;
     CREATE USER postgres WITH PASSWORD '02022006';
     ```

4. **Executar aplicação**
   ```bash
   mvn spring-boot:run
   ```

5. **Acessar endpoints**
   - API: `http://localhost:8080`
   - Swagger: `http://localhost:8080/swagger-ui.html`
   - H2 Console (dev): `http://localhost:8080/h2-console`

---

## 18. Contato e Suporte

**Desenvolvedor:** jhefferson  
**Email:** jhefferson.7980@gmail.com  
**Repositório:** https://github.com/jheffersonjm/Spring-Bott_E_Angular-Projeto_Filme  
**Data da Última Atualização:** Dezembro 4, 2025

---

## 19. Anexos

### A. Estrutura de Resposta JSON

#### Sucesso (200 OK)
```json
{
  "id": 1,
  "title": "Avatar",
  "descrition": "Um filme de ficção científica",
  "anoLancamento": 2009,
  "imagemUrl": "https://image.url",
  "tipoObra": "Filme",
  "genero": {
    "id": 1,
    "nome": "Ficção Científica"
  }
}
```

#### Erro (404 Not Found)
```json
{
  "status": 404,
  "message": "Obra não encontrada",
  "timestamp": "2025-12-04T10:30:00Z"
}
```

### B. Comandos Úteis

```bash
# Compilar
mvn clean compile

# Build
mvn clean package

# Executar
java -jar target/filmes-0.0.1-SNAPSHOT.jar

# Tests
mvn test

# Ver dependências
mvn dependency:tree

# Update dependencies
mvn versions:display-dependency-updates
```
