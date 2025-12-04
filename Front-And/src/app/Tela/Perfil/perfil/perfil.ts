import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TelaLoginService, Logar } from '../../../Service/Tela_Login/tela-login-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './perfil.html',
  styleUrl: './perfil.css',
})
export class Perfil implements OnInit {
  usuario: Logar | null = null;

  constructor(
    private loginService: TelaLoginService,
    private router: Router
  ) {}

  ngOnInit() {
    this.usuario = this.loginService.getUsuarioLogado();
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }
}
