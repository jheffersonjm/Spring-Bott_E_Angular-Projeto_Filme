import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TelaLoginService, Logar } from '../../Service/Tela_Login/tela-login-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  usuario: Logar | null = null;

  constructor(
    private loginService: TelaLoginService,
    private router: Router
  ) {}

  ngOnInit() {
    this.usuario = this.loginService.getUsuarioLogado();
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['/']);
  }

  configuracao(){ 
    this.router.navigate(['Configuracao']);
  }

  conteudo(){
    this.router.navigate(['conteudo']);
  }

  criarGenero(){
    this.router.navigate(['CriarGenero']);
  }
}
