import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { lastValueFrom } from 'rxjs';
import { ConteudoService } from '../../../Service/Conteudo/conteudo-service';

@Component({
  selector: 'app-conteudo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './conteudo.html',
  styleUrl: './conteudo.css',
})
export class Conteudo implements OnInit {
  Conteudo$: any;

  constructor(private router: Router, private conteudoService: ConteudoService) {}

  ngOnInit(): void {
    this.getObras();
  }

  voltarHome() {
    this.router.navigate(['/home']);
  }

  public async getObras() {
    this.Conteudo$ = await lastValueFrom(this.conteudoService.getObras());
    console.log(this.Conteudo$);
  }

  public editar(id: number) {
    this.router.navigate(['/obra/editar', id]);
  }

  public deletar(id: number) {
    // Em breve: chamada de exclusão ao service
    console.log('Deletar obra', id);
  }

  public login() {
    this.router.navigate(['/login']);
  }

  public Nota(){ 
    this.router.navigate(['Nota']);
  }

  criarConteudo() {
    this.router.navigate(['CriarConteudo']);
  }
}

