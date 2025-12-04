import { RenderMode, ServerRoute } from '@angular/ssr';
import { Routes } from '@angular/router';
import { TelaLogin } from './Tela/tela-login/tela-login';
import { Home } from './Tela/home/home';
export const serverRoutes: ServerRoute[] = [
  {
    path: '**',
    renderMode: RenderMode.Prerender
  },
  {
    path: '',
    renderMode: RenderMode.Client
  }
];
