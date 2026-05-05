import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

// Interface para o retorno do login
export interface Logar {
  id?: number;
  gmail?: string;
  senha?: string;
  username?: string;
  token?: string;
}

@Injectable({
  providedIn: 'root',
})        
export class TelaLoginService {
  private url = 'http://localhost:8080/usuario'; 
  
  constructor(private http: HttpClient) {}

  // Listar todos os usuários (para validação no front)
  public getUsuario(){ 
    return this.http.get<Logar[]>(this.url + '/listar');
  }

  // Método para autenticar (se o backend tiver endpoint específico)
  public autenticar(gmail: string, senha: string): Observable<Logar> {
    return this.http.post<Logar>(this.url + '/listar', { gmail, senha });
  }

  // Verificar se o usuário está logado
  public estaLogado(): boolean {
    return localStorage.getItem('usuario') !== null;
  }

  // Obter usuário logado
  public getUsuarioLogado(): Logar | null {
    const usuario = localStorage.getItem('usuario');
    return usuario ? JSON.parse(usuario) : null;
  }

  // Fazer logout
  public logout(): void {
    localStorage.removeItem('usuario');
  }
}