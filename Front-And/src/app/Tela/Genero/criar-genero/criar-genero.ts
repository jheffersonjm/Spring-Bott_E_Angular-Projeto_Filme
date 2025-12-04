import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Genero } from '../../../Service/Genero/genero';

@Component({
  selector: 'app-criar-genero',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './criar-genero.html',
  styleUrl: './criar-genero.css',
})
export class CriarGenero {
  nome: string = '';

  constructor(private router: Router, private generoService: Genero) {}

  voltar() {
    this.router.navigate(['Genero']);
  }

  criarGenero(): void {
    if (!this.nome.trim()) {
      return;
    }
    this.generoService.adicionarGenero({ nome: this.nome }).subscribe({
      next: () => this.router.navigate(['Genero']),
      error: (err) => console.error('Erro ao criar gênero:', err),
    });
  }
}
