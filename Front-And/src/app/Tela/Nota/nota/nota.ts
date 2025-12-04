import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nota',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './nota.html',
  styleUrl: './nota.css',
})
export class Nota {
  nota: number | null = null;
  comentario: string = '';
  data: Date | null = null;

  // Id do usuário
  id: number | null = null;
  // Dados do usuário
  nomeUsuario: string = '';
  emailUsuario: string = '';
  senhaUsuario: string = '';

  // Dados do conteúdo
  idConteudo: number | null = null;
  tituloConteudo: string = '';
  descricaoConteudo: string = '';
  anoLancamentoConteudo: number | null = null;
  imagemURL: string = '';
  tipoconteudo: string = '';

  // Dados do gênero
  genero = {
    generoid: null as number | null,
    nomeGenero: '' as string,
  };
  constructor(private router: Router) {}

  public salvarNota(){
    // validação básica da nota
    if (this.nota === null || this.nota < 0 || this.nota > 10) {
      alert('Por favor, informe uma nota válida entre 0 e 10.');
      return;
    }

    const payload = {
      nota: this.nota,
      comentario: this.comentario,
      data: this.data ?? new Date(),
      id: this.id,
      nomeUsuario: this.nomeUsuario,
      emailUsuario: this.emailUsuario,
      senhaUsuario: this.senhaUsuario,
      idConteudo: this.idConteudo,
      tituloConteudo: this.tituloConteudo,
      descricaoConteudo: this.descricaoConteudo,
      anoLancamentoConteudo: this.anoLancamentoConteudo,
      imagemURL: this.imagemURL,
      tipoconteudo: this.tipoconteudo,
      genero: {
        generoid: this.genero.generoid,
        nomeGenero: this.genero.nomeGenero,
      },
    };

    console.log('Nota salva:', payload);
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }
}
