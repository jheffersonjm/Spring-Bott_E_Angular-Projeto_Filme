# Relatório - Front-End Angular

## 📋 Informações Gerais

**Projeto:** Front-And (Front-End do Sistema de Gerenciamento de Filmes)  
**Framework:** Angular 20.3.0  
**Linguagem:** TypeScript 5.9.2  
**Build Tool:** Angular CLI 20.3.10  
**Package Manager:** npm  
**Versão:** 0.0.0  
**Data do Relatório:** Dezembro 2025  
**Status:** Em Desenvolvimento

---

## 1. Tecnologias Utilizadas

### Dependências Principais

| Pacote | Versão | Função |
|--------|--------|--------|
| @angular/common | ^20.3.0 | Componentes comuns do Angular |
| @angular/core | ^20.3.0 | Core do Angular |
| @angular/forms | ^20.3.0 | Formulários reativos e template-driven |
| @angular/platform-browser | ^20.3.0 | Browser platform |
| @angular/platform-server | ^20.3.0 | Server-side rendering |
| @angular/router | ^20.3.0 | Roteamento entre componentes |
| @angular/ssr | ^20.3.10 | Server-Side Rendering |
| express | ^5.1.0 | Runtime para SSR |
| rxjs | ~7.8.0 | Programação reativa (Observables) |
| tslib | ^2.3.0 | Utilitários TypeScript |

### Dependências de Desenvolvimento

| Pacote | Versão | Função |
|--------|--------|--------|
| @angular/build | ^20.3.10 | Build Angular |
| @angular/cli | ^20.3.10 | Command Line Interface |
| @angular/compiler-cli | ^20.3.0 | Compilador Angular |
| @types/express | ^5.0.1 | Tipagem para Express |
| @types/jasmine | ~5.1.0 | Tipagem Jasmine |
| @types/node | ^20.17.19 | Tipagem Node.js |
| jasmine-core | ~5.9.0 | Framework de testes |
| karma | ~6.4.0 | Test runner |
| karma-chrome-launcher | ~3.2.0 | Chrome launcher para testes |
| karma-coverage | ~2.2.0 | Cobertura de testes |
| karma-jasmine | ~5.1.0 | Integração Jasmine/Karma |
| karma-jasmine-html-reporter | ~2.1.0 | Reporter HTML |
| typescript | ~5.9.2 | Compilador TypeScript |

---

## 2. Estrutura de Diretórios

```
Front-And/
│
├── 📄 angular.json                  # Configuração do Angular CLI
├── 📄 package.json                  # Dependências e scripts
├── 📄 package-lock.json             # Lock file das dependências
├── 📄 tsconfig.json                 # Configuração TypeScript base
├── 📄 tsconfig.app.json             # Configuração TypeScript aplicação
├── 📄 tsconfig.spec.json            # Configuração TypeScript testes
├── 📄 README.md                     # Documentação do projeto
│
├── 📁 public/                       # Assets estáticos públicos
│
└── 📁 src/
    ├── 📄 index.html                # HTML principal (renderizado)
    ├── 📄 main.ts                   # Entry point da aplicação
    ├── 📄 main.server.ts            # Entry point SSR
    ├── 📄 server.ts                 # Express server para SSR
    ├── 📄 styles.css                # Estilos globais
    │
    └── 📁 app/
        ├── 📄 app.ts                # Componente raiz (root component)
        ├── 📄 app.css               # Estilos do componente raiz
        ├── 📄 app.html              # Template do componente raiz
        ├── 📄 app.spec.ts           # Testes do componente raiz
        ├── 📄 app.routes.ts         # Rotas da aplicação (Client)
        ├── 📄 app.routes.server.ts  # Rotas SSR (Server)
        ├── 📄 app.config.ts         # Configuração Angular
        ├── 📄 app.config.server.ts  # Configuração SSR
        │
        ├── 📁 guards/               # Guardas de rota
        │   └── 📄 auth.guard.ts     # Guard de autenticação
        │
        ├── 📁 Service/              # Serviços (Business Logic)
        │   ├── 📁 Conteudo/
        │   │   ├── 📄 conteudo-service.ts
        │   │   └── 📄 conteudo-service.spec.ts
        │   ├── 📁 Genero/
        │   │   ├── 📄 genero.ts
        │   │   └── 📄 genero.spec.ts
        │   ├── 📁 Home/
        │   │   ├── 📄 home-service.ts
        │   │   └── 📄 home-service.spec.ts
        │   ├── 📁 Nota/
        │   │   ├── 📄 nota-service.ts
        │   │   └── 📄 nota-service.spec.ts
        │   └── 📁 Tela_Login/
        │       ├── 📄 tela-login-service.ts
        │       └── 📄 tela-login-service.spec.ts
        │
        └── 📁 Tela/                 # Componentes (UI)
            ├── 📁 Configuracao/
            │   └── 📁 configuracao/
            │       ├── 📄 configuracao.ts
            │       ├── 📄 configuracao.html
            │       ├── 📄 configuracao.css
            │       └── 📄 configuracao.spec.ts
            │
            ├── 📁 Coteudo/          # [NOTA: Possível typo - deveria ser "Conteudo"]
            │   ├── 📁 conteudo/
            │   │   ├── 📄 conteudo.ts
            │   │   ├── 📄 conteudo.html
            │   │   ├── 📄 conteudo.css
            │   │   └── 📄 conteudo.spec.ts
            │   └── 📁 criar-conteudo/
            │       ├── 📄 criar-conteudo.ts
            │       ├── 📄 criar-conteudo.html
            │       ├── 📄 criar-conteudo.css
            │       └── 📄 criar-conteudo.spec.ts
            │
            ├── 📁 Genero/
            │   ├── 📁 genero/
            │   │   ├── 📄 genero.ts
            │   │   ├── 📄 genero.html
            │   │   ├── 📄 genero.css
            │   │   └── 📄 genero.spec.ts
            │   └── 📁 criar-genero/
            │       ├── 📄 criar-genero.ts
            │       ├── 📄 criar-genero.html
            │       ├── 📄 criar-genero.css
            │       └── 📄 criar-genero.spec.ts
            │
            ├── 📁 home/
            │   ├── 📄 home.ts
            │   ├── 📄 home.html
            │   ├── 📄 home.css
            │   └── 📄 home.spec.ts
            │
            ├── 📁 Nota/
            │   ├── 📁 nota/
            │   │   ├── 📄 nota.ts
            │   │   ├── 📄 nota.html
            │   │   ├── 📄 nota.css
            │   │   └── 📄 nota.spec.ts
            │   └── [Subcomponentes]
            │
            ├── 📁 Perfil/
            │   ├── 📁 perfil/
            │   │   ├── 📄 perfil.ts
            │   │   ├── 📄 perfil.html
            │   │   ├── 📄 perfil.css
            │   │   └── 📄 perfil.spec.ts
            │   └── [Subcomponentes]
            │
            └── 📁 tela-login/
                ├── 📄 tela-login.ts
                ├── 📄 tela-login.html
                ├── 📄 tela-login.css
                └── 📄 tela-login.spec.ts
```

---

## 3. Componentes Principais

### 3.1 Sistema de Roteamento

**Arquivo:** `app.routes.ts` e `app.routes.server.ts`

Rotas implementadas:
- `/` - **Home** (página inicial)
- `/TelaLogin` - **Login** (autenticação)
- `/perfil` - **Perfil** (informações do usuário)
- `/configuracao` - **Configurações**
- `/conteudo` - **Listar Conteúdo** (filmes)
- `/conteudo/criar` - **Criar Conteúdo**
- `/nota` - **Notas/Avaliações**
- `/genero` - **Listar Gêneros**
- `/genero/criar` - **Criar Gênero**

### 3.2 Componentes (Tela)

#### **1. TelaLogin**
- **Caminho:** `src/app/Tela/tela-login/`
- **Função:** Autenticação de usuários
- **Elementos:** Formulário de login, validação
- **Guard:** Sem proteção (pública)

#### **2. Home**
- **Caminho:** `src/app/Tela/home/`
- **Função:** Página inicial / Dashboard
- **Guard:** Sem proteção (pública, mas pode ter dados protegidos)
- **Conteúdo:** Filmes em destaque, recomendações

#### **3. Conteudo**
- **Caminho:** `src/app/Tela/Coteudo/conteudo/`
- **Função:** Exibição de filmes/conteúdo
- **Guard:** `authGuard` (protegida)
- **Ações:** Visualizar, editar, deletar

#### **4. CriarConteudo**
- **Caminho:** `src/app/Tela/Coteudo/criar-conteudo/`
- **Função:** Formulário para criar novo conteúdo
- **Guard:** `authGuard` (protegida)
- **Campos:** Título, sinopse, gênero, etc.

#### **5. Genero**
- **Caminho:** `src/app/Tela/Genero/genero/`
- **Função:** Listagem de gêneros
- **Guard:** `authGuard` (protegida)
- **Ações:** Visualizar, editar, deletar

#### **6. CriarGenero**
- **Caminho:** `src/app/Tela/Genero/criar-genero/`
- **Função:** Formulário para criar novo gênero
- **Guard:** `authGuard` (protegida)
- **Campos:** Nome, descrição, etc.

#### **7. Nota**
- **Caminho:** `src/app/Tela/Nota/nota/`
- **Função:** Sistema de avaliações/ratings
- **Guard:** `authGuard` (protegida)
- **Ações:** Adicionar nota, visualizar notas

#### **8. Perfil**
- **Caminho:** `src/app/Tela/Perfil/perfil/`
- **Função:** Perfil do usuário
- **Guard:** `authGuard` (protegida)
- **Informações:** Dados pessoais, preferências

#### **9. Configuracao**
- **Caminho:** `src/app/Tela/Configuracao/configuracao/`
- **Função:** Configurações da aplicação
- **Guard:** `authGuard` (protegida)
- **Opções:** Tema, idioma, notificações

### 3.3 Serviços (Business Logic)

#### **1. ConteudoService**
- **Arquivo:** `src/app/Service/Conteudo/conteudo-service.ts`
- **Métodos:**
  - `getConteudo()` - Obter lista de conteúdo
  - `getConteudoById(id)` - Obter conteúdo específico
  - `createConteudo(data)` - Criar novo conteúdo
  - `updateConteudo(id, data)` - Atualizar conteúdo
  - `deleteConteudo(id)` - Deletar conteúdo
- **Comunicação:** HTTP (REST API)

#### **2. GeneroService**
- **Arquivo:** `src/app/Service/Genero/genero.ts`
- **Métodos:**
  - `getGeneros()` - Obter lista de gêneros
  - `getGeneroById(id)` - Obter gênero específico
  - `createGenero(data)` - Criar novo gênero
  - `updateGenero(id, data)` - Atualizar gênero
  - `deleteGenero(id)` - Deletar gênero

#### **3. NotaService**
- **Arquivo:** `src/app/Service/Nota/nota-service.ts`
- **Métodos:**
  - `getNotas()` - Obter notas/avaliações
  - `addNota(conteudoId, nota)` - Adicionar avaliação
  - `updateNota(id, nota)` - Atualizar avaliação

#### **4. HomeService**
- **Arquivo:** `src/app/Service/Home/home-service.ts`
- **Métodos:**
  - `getDestaques()` - Obter conteúdo em destaque
  - `getRecomendacoes()` - Obter recomendações personalizadas

#### **5. TelaLoginService**
- **Arquivo:** `src/app/Service/Tela_Login/tela-login-service.ts`
- **Métodos:**
  - `login(username, password)` - Autenticar usuário
  - `logout()` - Desconectar usuário
  - `register(userData)` - Registrar novo usuário
  - `isAuthenticated()` - Verificar autenticação

### 3.4 Guards (Proteção de Rotas)

#### **AuthGuard**
- **Arquivo:** `src/app/guards/auth.guard.ts`
- **Função:** Proteger rotas que requerem autenticação
- **Lógica:**
  - Verifica se usuário está autenticado
  - Redireciona para login se não autenticado
  - Valida token/sessão
- **Rotas Protegidas:**
  - Conteúdo
  - Criar Conteúdo
  - Gêneros
  - Criar Gêneros
  - Notas
  - Perfil
  - Configurações

---

## 4. Padrões e Arquitetura

### 4.1 Padrão Component-Based
- Cada tela/página é um componente Angular
- Componentes reutilizáveis quando possível
- Separação de responsabilidade (Component + Service)

### 4.2 Padrão Service
- Lógica de negócio em serviços
- Comunicação com API centralizada
- Injeção de dependência via constructor

### 4.3 Padrão Guard
- Proteção de rotas via Guards
- Validação de autenticação antes de acesso
- Redirecionamento automático

### 4.4 Programação Reativa
- Uso de RxJS Observables
- Subscribe em componentes para dados assíncronos
- Manipulação de fluxos de dados

---

## 5. Configuração

### 5.1 TypeScript Configuration
- **Arquivo:** `tsconfig.json`
- **Modo Strict:** Habilitado
- **Target:** ES2022
- **Strict Properties:** Sim
- **Strict Templates:** Sim

### 5.2 Angular Configuration
- **Arquivo:** `angular.json`
- **Build Output:** `dist/Front-And`
- **Server Entry:** `src/main.server.ts`
- **SSR:** Habilitado
- **Assets:** Pasta `public/`
- **Styles:** `src/styles.css`

### 5.3 Prettier Configuration
```json
{
  "printWidth": 100,
  "singleQuote": true,
  "files": "*.html" (parser: "angular")
}
```

---

## 6. Scripts Disponíveis

| Script | Comando | Função |
|--------|---------|--------|
| `start` | `ng serve` | Inicia dev server |
| `build` | `ng build` | Build produção |
| `watch` | `ng build --watch --configuration development` | Watch mode |
| `test` | `ng test` | Executa testes |
| `serve:ssr:Front-And` | `node dist/Front-And/server/server.mjs` | Serve com SSR |

---

## 7. Testing

### Framework: Jasmine 5.9.0
### Test Runner: Karma 6.4.0

**Estrutura de Testes:**
- Cada componente possui arquivo `.spec.ts`
- Cobertura de testes com Karma Coverage
- Testes executáveis via `npm test`

**Arquivos de Teste:**
- `app.spec.ts` - Testes do componente raiz
- `conteudo.spec.ts` - Testes do componente conteúdo
- `conteudo-service.spec.ts` - Testes do serviço
- E mais...

---

## 8. Server-Side Rendering (SSR)

### Configuração SSR
- **Entry Point:** `src/main.server.ts`
- **Express Server:** `src/server.ts`
- **Rotas SSR:** `src/app/app.routes.server.ts`
- **Build:** Gera arquivo `.mjs` em `dist/Front-And/server/`

### Benefícios
- SEO melhorado
- Carregamento inicial mais rápido
- Melhor compatibilidade com navegadores antigos

---

## 9. Fluxo de Dados

```
┌────────────────────────────────────┐
│      Usuário (Browser)              │
└────────────────┬───────────────────┘
                 │
         [User Interaction]
                 │
┌────────────────▼───────────────────┐
│      Component (Tela)               │
│  • Renderiza HTML/Template          │
│  • Captura eventos do usuário       │
└────────────────┬───────────────────┘
                 │
      [Chamada de método / Injeção]
                 │
┌────────────────▼───────────────────┐
│      Service                        │
│  • Lógica de negócio                │
│  • Chamadas HTTP                    │
└────────────────┬───────────────────┘
                 │
     [HttpClient / Observable]
                 │
┌────────────────▼───────────────────┐
│      Backend (Spring Boot)          │
│  • REST API                         │
│  • Processamento de dados           │
└────────────────┬───────────────────┘
                 │
        [JSON Response]
                 │
┌────────────────▼───────────────────┐
│      Database                       │
│  • PostgreSQL                       │
│  • Persistência de dados            │
└────────────────────────────────────┘
```

---

## 10. Comunicação com Backend

### HTTP Client
- Baseado em `@angular/common/http`
- Requisições JSON
- Headers padrão: `Content-Type: application/json`

### Endpoints Base
```
http://localhost:4200/api/
```

### Exemplos de Requisições

**GET - Obter Filmes**
```typescript
GET /api/filmes
Response: { filmes: [...] }
```

**POST - Criar Filme**
```typescript
POST /api/filmes
Body: { titulo: "...", sinopse: "...", ... }
Response: { id: 1, ... }
```

**PUT - Atualizar Filme**
```typescript
PUT /api/filmes/:id
Body: { titulo: "...", ... }
Response: { id: 1, ... }
```

**DELETE - Deletar Filme**
```typescript
DELETE /api/filmes/:id
Response: { success: true }
```

---

## 11. Gestão de Estado e Observables

### RxJS Observables
- Usado em serviços para comunicação assíncrona
- Componentes fazem subscribe em Observables
- Permite tratamento de erros e transformações de dados

### Exemplo Padrão
```typescript
// Em Service
getFilmes(): Observable<Filme[]> {
  return this.http.get<Filme[]>('/api/filmes');
}

// Em Componente
this.filmeService.getFilmes().subscribe(
  (filmes) => this.filmes = filmes,
  (error) => console.error(error)
);
```

---

## 12. Build e Deploy

### Build Produção
```bash
npm install
npm run build
```

Output: `dist/Front-And/browser/`

### Build com SSR
```bash
npm run build
node dist/Front-And/server/server.mjs
```

### Desenvolvimento
```bash
npm start
# Acessar em http://localhost:4200
```

---

## 13. Ambiente de Desenvolvimento

### Requisitos
- Node.js 20.x+
- npm 10.x+
- Angular CLI 20.3.10

### Setup Inicial
```bash
cd Front-And
npm install
npm start
```

### Hot Reload
- Ativado por padrão em `ng serve`
- Alterações em arquivos são refletidas automaticamente

---

## 14. Problemas Identificados

1. **Typo no Nome:** Pasta `Coteudo/` deveria ser `Conteudo/`
2. **Inconsistência de Nomes:** Padrão de nomenclatura misto (snake_case e PascalCase)
3. **Falta de Erros/Validações:** Muitos serviços podem estar sem tratamento de erro
4. **Documentação de API:** Endpoints não documentados em comentários

---

## 15. Recomendações

### Melhorias Imediatas
- [ ] Renomear pasta `Coteudo/` para `Conteudo/`
- [ ] Padronizar nomenclatura (PascalCase para classes, camelCase para variáveis)
- [ ] Adicionar tratamento de erros em todos os serviços
- [ ] Implementar logging centralizado
- [ ] Adicionar validação de formulários

### Segurança
- [ ] Implementar JWT para autenticação
- [ ] Armazenar token em HttpOnly Cookie
- [ ] Adicionar CSRF protection
- [ ] Validar entrada de dados

### Performance
- [ ] Implementar lazy loading de componentes
- [ ] Cache de dados com RxJS `shareReplay()`
- [ ] Otimizar bundle size
- [ ] OnPush change detection

### Testing
- [ ] Aumentar cobertura de testes
- [ ] Implementar testes E2E com Cypress/Playwright
- [ ] Testes de integração com backend
- [ ] Testes de performance

### DevOps
- [ ] CI/CD pipeline (GitHub Actions)
- [ ] Docker container
- [ ] Environment variables via `.env`
- [ ] Staging environment

---

## 16. Checklist de Qualidade

- [ ] Compilação sem erros
- [ ] Build produção gera artefatos
- [ ] Testes passando
- [ ] Cobertura de testes > 80%
- [ ] SSR funcionando
- [ ] Componentes reutilizáveis
- [ ] Guards protegendo rotas
- [ ] Serviços com DI correto
- [ ] Sem console.error/warnings
- [ ] Documentação atualizada

---

## 17. Contato e Suporte

**Desenvolvedor:** jhefferson  
**Projeto:** Spring-Boot & Angular - Projeto Filme  
**Repositório:** Spring-Bott_E_Angular-Projeto_Filme  
**Data da Última Atualização:** Dezembro 4, 2025

---

## 18. Anexos

### 18.1 Estrutura de um Componente Padrão

```typescript
// componente.ts
import { Component, OnInit } from '@angular/core';
import { Service } from '../service/service';

@Component({
  selector: 'app-componente',
  templateUrl: './componente.html',
  styleUrl: './componente.css'
})
export class Componente implements OnInit {
  dados: any[];

  constructor(private service: Service) {}

  ngOnInit(): void {
    this.carregarDados();
  }

  carregarDados(): void {
    this.service.getData().subscribe(
      (response) => this.dados = response,
      (error) => console.error(error)
    );
  }
}
```

### 18.2 Estrutura de um Serviço Padrão

```typescript
// service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Service {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getData(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/dados`);
  }
}
```

### 18.3 Estrutura de um Guard

```typescript
// auth.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    if (this.isAuthenticated()) {
      return true;
    }
    this.router.navigate(['/TelaLogin']);
    return false;
  }

  private isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
  }
}
```
