import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ConteudoService } from '../../../Service/Conteudo/conteudo-service';
import { Genero } from '../../../Service/Genero/genero';

@Component({
  selector: 'app-criar-conteudo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './criar-conteudo.html',
  styleUrl: './criar-conteudo.css',
})
export class CriarConteudo implements OnInit {
  title: string = '';
  descricao: string = '';
  anoLancamento: number = 0;
  imagemURL: string = '';
  tipoconteudo: string = '';
  generoSelecionado: any = null;
  generos: any[] = [];

  constructor(
    private router: Router,
    private conteudoService: ConteudoService,
    private generoService: Genero
  ) {}

  ngOnInit() {
    this.carregarGeneros();
  }

  carregarGeneros() {
    this.generoService.listarGeneros().subscribe({
      next: (data) => {
        this.generos = data;
      },
      error: (error) => {
        console.error('Erro ao carregar gêneros:', error);
      }
    });
  }

  voltarHome() {
    this.router.navigate(['/conteudo']);
  }

  criarConteudo() {
    const obra = {
      title: this.title,
      descricao: this.descricao,
      anoLancamento: this.anoLancamento,
      imagemURL: this.imagemURL,
      tipoconteudo: this.tipoconteudo,
      genero: this.generoSelecionado
    };

    this.conteudoService.criar(obra).subscribe({
      next: (response) => {
        console.log('Conteúdo criado com sucesso:', response);
        this.router.navigate(['/conteudo']);
      },
      error: (error) => {
        console.error('Erro ao criar conteúdo:', error);
      }
    });
  }
}
