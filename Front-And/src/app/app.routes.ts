import { Routes } from '@angular/router';
import { TelaLogin } from './Tela/tela-login/tela-login';
import { Home } from './Tela/home/home';
import { authGuard } from './guards/auth.guard';
import { Perfil } from './Tela/Perfil/perfil/perfil';
import { Configuracao } from './Tela/Configuracao/configuracao/configuracao';
import { Conteudo } from './Tela/Coteudo/conteudo/conteudo';
import { Nota } from './Tela/Nota/nota/nota';
import { Genero } from './Tela/Genero/genero/genero';
import { CriarConteudo } from './Tela/Coteudo/criar-conteudo/criar-conteudo';
import { CriarGenero } from './Tela/Genero/criar-genero/criar-genero';

export const routes: Routes = [
    { 
        path: '', 
        component: Home
    }, 
    { 
        path: 'TelaLogin', 
        component: TelaLogin
    },
    { 
        path: 'home', 
        component: Home,
        canActivate: [authGuard]
    },
    {
        path: 'Perfil',
        component: Perfil,
    }, 
    {
        path: 'Configuracao',
        component: Configuracao,
    }, 
    { 
        path: 'conteudo', 
        component:Conteudo,
    }, 
    { 
        path: 'Nota', 
        component: Nota, 
    }, 
    { 
        path: 'Genero',
        component: Genero,
    },
    {
        path: 'CriarConteudo',
        component: CriarConteudo,
    }
    ,
    {
        path: 'CriarGenero',
        component: CriarGenero,
    }
];
