import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConteudoService {
   url=  'http://localhost:8080/obra/'; 
  private http: HttpClient;
  constructor(handle: HttpBackend) {
    this.http = new HttpClient(handle);
  }
  public getObras(){ 
    return this.http.get(this.url + 'lista').pipe(map(resposta => resposta));
  }
  
  public getObraById(id: number){
  return this.http.get(this.url + 'lista/' + id).pipe(map(response => response));
  }

  public salvar(obra: any): Observable<any> {
    if (obra.id !== null){
      return this.http.put(this.url + 'atualizar/'+ obra.id, obra);
    }
    return this.http.post(this.url + 'novo', obra);
  }
public deletar(id: number): Observable<any> {
  return this.http.delete(this.url + 'deletar/' + id);
}

  public criar(obra: { title: string; descricao: string; anoLancamento: number; imagemURL: string; tipoconteudo: string; genero: any }): Observable<any> { 
    return this.http.post(this.url + 'novo', obra);
  }
}
