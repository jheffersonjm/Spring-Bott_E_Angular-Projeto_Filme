import { Component, OnInit } from '@angular/core';
import { CommonModule, NgIf, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Genero as GeneroService } from '../../../Service/Genero/genero';

@Component({
  selector: 'app-genero',
  standalone: true,
  imports: [CommonModule, NgIf, NgFor, FormsModule],
  templateUrl: './genero.html',
  styleUrl: './genero.css',
})
export class Genero implements OnInit {
  nome: string = '';
  generos: { id: number; nome: string }[] = [];
  private nextId = 1;

  constructor(private router: Router, private generoService: GeneroService) {}

  ngOnInit(): void {
    this.listar();
  }

  adicionarGenero() {
    const nome = this.nome?.trim();
    if (!nome) return;
    this.generos = [...this.generos, { id: this.nextId++, nome }];
    this.nome = '';
    this.salvar();
  }

  removerGenero(id: number) {
    this.generos = this.generos.filter(g => g.id !== id);
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }

  private listar() {
    this.generoService.listarGeneros().subscribe((lista: any) => {
      // espera [{id, nome}, ...]
      if (Array.isArray(lista)) {
        this.generos = lista;
        // ajustar nextId para não conflitar
        const maxId = this.generos.reduce((m, g) => Math.max(m, g.id ?? 0), 0);
        this.nextId = maxId + 1;
      }
    });
  }

  private salvar() {
    this.generoService.adicionarGenero({ nome: this.generos[this.generos.length - 1].nome })
      .subscribe(() => this.listar());
  }
}
