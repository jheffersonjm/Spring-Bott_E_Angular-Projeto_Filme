import { Injectable } from '@angular/core';
import { Nota } from '../../Tela/Nota/nota/nota';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class NotaService {
  private url= 'http://localhost:8081/avaliacao';
  private http: HttpClient; 
  
  constructor(http: HttpClient) { 
    this.http = http;
  }

  public getNotas(){ 
    // Lógica para obter notas
    return this.http.get(this.url + '/lista');
   

  }
}
