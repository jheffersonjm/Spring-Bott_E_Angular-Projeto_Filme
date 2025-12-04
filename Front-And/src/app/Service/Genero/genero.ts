import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Genero {
  private url = 'http://localhost:8080/genero/';
  private http: HttpClient;

  constructor(handle: HttpBackend) {
    this.http = new HttpClient(handle);
  }

  public adicionarGenero(genero: { nome: string }): Observable<any> {
    return this.http.post(this.url + 'novo', genero);
  }

  public listarGeneros(): Observable<any> {
    return this.http.get(this.url + 'lista').pipe(map(resposta => resposta));
  }

  public removerGenero(id: number): Observable<any> {
    return this.http.delete(this.url + 'deletar/' + id);
  }
}
