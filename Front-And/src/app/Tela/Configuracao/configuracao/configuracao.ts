import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-configuracao',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './configuracao.html',
  styleUrl: './configuracao.css',
})
export class Configuracao {
  constructor(private router: Router) {}

  irParaPerfil() {
    this.router.navigate(['/Perfil']);
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }
}
