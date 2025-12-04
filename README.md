# Spring-Boot & Angular - Projeto Filme

## 📋 Relatório do Sistema

### 1. Visão Geral
**Projeto:** Sistema de Gerenciamento de Filmes  
**Arquitetura:** Full Stack - Backend (Spring Boot) + Frontend (Angular)  
**Versão:** 0.0.1-SNAPSHOT  
**Data do Relatório:** Dezembro 2025  
**Autor:** jhefferson

---

## 2. Stack Tecnológico

### Backend
- **Framework:** Spring Boot 3.5.7
- **Linguagem:** Java 21
- **Build Tool:** Maven
- **Database:** PostgreSQL (Produção) / H2 (Testes)
- **ORM:** JPA (Spring Data JPA)
- **API Documentation:** OpenAPI / Swagger (SpringDoc-OpenAPI 2.8.13)
- **Utilitários:** Lombok

### Frontend
- **Framework:** Angular 20.3.0
- **Linguagem:** TypeScript
- **Build Tool:** Angular CLI 20.3.10
- **SSR:** Angular SSR 20.3.10
- **Runtime:** Express 5.1.0
- **Reatividade:** RxJS 7.8.0
- **Testing:** Jasmine 5.9.0, Karma 6.4.0

---

## 3. Estrutura do Projeto

### 3.1 Backend (Spring Boot)
```
filmes/filmes/
├── pom.xml                           # Configuração Maven
├── mvnw / mvnw.cmd                   # Maven Wrapper
├── docker-compose.yml                # Orquestração de containers
├── src/
│   ├── main/
│   │   ├── java/br/com/jhefferson/   # Código fonte Java
│   │   └── resources/
│   │       ├── application.properties      # Config padrão
│   │       └── application-dev.properties  # Config desenvolvimento
│   └── test/
│       └── java/br/com/jhefferson/   # Testes unitários
└── target/                           # Artefatos compilados
```

### 3.2 Frontend (Angular)
```
Front-And/
├── angular.json                      # Configuração Angular
├── package.json                      # Dependências npm
├── tsconfig.json / tsconfig.app.json # Configuração TypeScript
├── public/                           # Assets estáticos
└── src/
    ├── index.html                    # HTML principal
    ├── main.ts                       # Inicialização da app
    ├── main.server.ts                # Inicialização SSR
    ├── server.ts                     # Express server para SSR
    └── app/
        ├── app.ts                    # Componente root
        ├── app.routes.ts             # Rotas da aplicação
        ├── app.routes.server.ts      # Rotas SSR
        ├── app.config.ts             # Configuração Angular
        ├── guards/
        │   └── auth.guard.ts         # Guard de autenticação
        ├── Service/
        │   ├── Conteudo/             # Serviço de conteúdo (filmes)
        │   ├── Genero/               # Serviço de gêneros
        │   ├── Home/                 # Serviço de home
        │   ├── Nota/                 # Serviço de avaliações/notas
        │   └── Tela_Login/           # Serviço de autenticação
        └── Tela/                     # Componentes (Telas)
            ├── Configuracao/         # Tela de configurações
            ├── Coteudo/              # Tela de conteúdo
            │   ├── conteudo/         # Visualizar conteúdo
            │   └── criar-conteudo/   # Criar novo conteúdo
            ├── Genero/               # Tela de gêneros
            │   └── criar-genero/     # Criar novo gênero
            ├── home/                 # Página inicial
            ├── Nota/                 # Tela de avaliações
            ├── Perfil/               # Tela de perfil do usuário
            └── tela-login/           # Tela de login
```

---

## 4. Funcionalidades do Sistema

### 4.1 Módulos Principais

#### **1. Autenticação e Login**
- **Arquivo:** `tela-login/` + `Tela_Login/tela-login-service.ts`
- **Funcionalidade:** Autenticação de usuários
- **Componentes:** Tela de login, serviço de autenticação

#### **2. Gerenciamento de Conteúdo (Filmes)**
- **Arquivo:** `Coteudo/` + `Conteudo/conteudo-service.ts`
- **Funcionalidades:**
  - Visualizar lista de filmes/conteúdo
  - Criar novo conteúdo
  - Editar conteúdo existente
  - Deletar conteúdo

#### **3. Gerenciamento de Gêneros**
- **Arquivo:** `Genero/` + `Genero/genero.ts`
- **Funcionalidades:**
  - Listar gêneros
  - Criar novo gênero
  - Associar gêneros ao conteúdo

#### **4. Sistema de Avaliações (Notas)**
- **Arquivo:** `Nota/` + `Nota/nota-service.ts`
- **Funcionalidades:**
  - Adicionar avaliação em conteúdo
  - Visualizar notas/ratings

#### **5. Perfil de Usuário**
- **Arquivo:** `Perfil/`
- **Funcionalidades:**
  - Visualizar dados do usuário
  - Gerenciar configurações pessoais

#### **6. Página Inicial**
- **Arquivo:** `home/` + `Home/home-service.ts`
- **Funcionalidades:**
  - Dashboard principal
  - Exibição de conteúdo em destaque

#### **7. Configurações**
- **Arquivo:** `Configuracao/`
- **Funcionalidades:**
  - Configurações da aplicação
  - Preferências do usuário

### 4.2 Segurança
- **Guard de Autenticação:** `guards/auth.guard.ts`
  - Protege rotas que requerem autenticação
  - Valida token/sessão do usuário

---

## 5. Dependências Principais

### Backend
| Dependência | Versão | Propósito |
|------------|--------|----------|
| Spring Boot Starter Web | 3.5.7 | REST APIs |
| Spring Data JPA | 3.5.7 | Acesso a dados |
| PostgreSQL Driver | Latest | Banco de dados |
| H2 Database | Latest | Testes em memória |
| Lombok | Latest | Geração de código boilerplate |
| SpringDoc OpenAPI | 2.8.13 | Documentação API Swagger |

### Frontend
| Dependência | Versão | Propósito |
|------------|--------|----------|
| Angular Core | 20.3.0 | Framework principal |
| Angular Router | 20.3.0 | Roteamento |
| Angular Forms | 20.3.0 | Formulários |
| RxJS | 7.8.0 | Programação reativa |
| Express | 5.1.0 | Server-side rendering |
| TypeScript | Latest | Linguagem |

---

## 6. Padrões e Arquitetura

### 6.1 Backend (Spring Boot)
- **Padrão MVC:** Model-View-Controller
- **Padrão Repository:** Data access layer
- **Injeção de Dependência:** Spring IoC Container
- **REST API:** Endpoints JSON

### 6.2 Frontend (Angular)
- **Padrão Component-Based:** Componentes reutilizáveis
- **Padrão Service:** Serviços para lógica de negócio
- **Padrão Guard:** Proteção de rotas
- **Programação Reativa:** RxJS Observables
- **TypeScript:** Type-safety

---

## 7. Fluxo de Dados

```
┌────────────────────────────────────────────────────┐
│                   ANGULAR FRONTEND                 │
│  ┌─────────────────────────────────────────────┐   │
│  │         Componentes (Tela)                  │   │
│  │  • tela-login • home • conteudo • genero    │   │
│  │  • nota • perfil • configuracao             │   │
│  └─────────────┬───────────────────────────────┘   │
│                │                                   │
│  ┌─────────────▼───────────────────────────────┐   │
│  │         Serviços                            │   │
│  │  • conteudo-service • genero.ts             │   │
│  │  • nota-service • home-service              │   │
│  │  • tela-login-service                       │   │
│  └─────────────┬───────────────────────────────┘   │
│                │                                   │
│  ┌─────────────▼───────────────────────────────┐   │
│  │         Guards                              │   │
│  │  • auth.guard.ts                            │   │
│  └─────────────┬───────────────────────────────┘   │
└────────────────┼───────────────────────────────────┘
                 │ HTTP Requests (REST API)
┌────────────────▼────────────────────────────────────┐
│                SPRING BOOT BACKEND                  │
│  ┌──────────────────────────────────────────────┐   │
│  │         REST Controllers                     │   │
│  │  • FilmeController • GeneroController        │   │
│  │  • NotaController • UsuarioController        │   │
│  └──────────────────┬───────────────────────────┘   │
│                     │                               │
│  ┌──────────────────▼───────────────────────────┐   │
│  │         Services / Lógica de Negócio         │   │
│  │  • FilmeService • GeneroService              │   │
│  │  • NotaService • UsuarioService              │   │
│  └──────────────────┬───────────────────────────┘   │
│                     │                               │
│  ┌──────────────────▼───────────────────────────┐   │
│  │         Repositories (JPA)                   │   │
│  │  • FilmeRepository • GeneroRepository        │   │
│  │  • NotaRepository • UsuarioRepository        │   │
│  └──────────────────┬───────────────────────────┘   │
└─────────────────────┼───────────────────────────────┘
                      │
┌─────────────────────▼────────────────────────────────┐
│              DATABASE (PostgreSQL)                   │
│  • Filmes • Generos • Notas • Usuarios               │
│  • Associações • Relacionamentos                     │
└──────────────────────────────────────────────────────┘
```

---

## 8. Configurações Ambientes

### Backend
- **application.properties:** Configuração padrão
- **application-dev.properties:** Configuração desenvolvimento
- **Docker Compose:** Orquestração de serviços (BD, App)

### Frontend
- **environment.ts:** Configuração produção
- **environment.development.ts:** Configuração desenvolvimento

---

## 9. Testing

### Backend
- Framework: JUnit (Spring Boot Starter Test)
- Estrutura: `src/test/java/br/com/jhefferson/`

### Frontend
- Framework: Jasmine 5.9.0
- Runner: Karma 6.4.0
- Coverage: Karma Coverage 2.2.0
- Scripts: `npm test` / `npm run test`

---

## 10. Build e Deploy

### Backend
```bash
# Compilar
mvn clean compile

# Testes
mvn test

# Build
mvn clean package

# Executar
java -jar target/filmes-0.0.1-SNAPSHOT.jar
```

### Frontend
```bash
# Instalar dependências
npm install

# Desenvolvimento
npm start

# Build produção
npm run build

# Build com SSR
npm run build -- --configuration production

# Testes
npm test
```

---

## 11. Docker

- **docker-compose.yml:** Configuração de containers
- **Serviços:** Backend (Spring Boot) + Database (PostgreSQL)

---

## 12. Documentação API

- **Swagger/OpenAPI:** Disponível via SpringDoc
- **Endpoint:** `http://localhost:8080/swagger-ui.html` (quando ativo)

---
## 15. Contato e Suporte

**Desenvolvedor:** jhefferson  
**Repositório:** Spring-Bott_E_Angular-Projeto_Filme  
**Data da Última Atualização:** Dezembro 4, 2025
