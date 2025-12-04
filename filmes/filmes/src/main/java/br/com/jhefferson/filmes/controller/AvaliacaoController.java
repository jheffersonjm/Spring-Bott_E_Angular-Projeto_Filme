package br.com.jhefferson.filmes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhefferson.filmes.model.Avaliacao;
import br.com.jhefferson.filmes.repositorio.AvaliacaoRepository;


@RestController /*ele vai indicar que ele e um Controlador ou seja seu metodo que retorna
que vai ser retornado um arquivo JSON*/
@RequestMapping (value = "avaliacao") /* ele vai ser definido em um prefixo da rota*/
public class AvaliacaoController {
   @Autowired // ele vai que vai ser feito para injetar uma istancia.
    AvaliacaoRepository avaliacaoRepository; // ele que vai ser feito para ter uma reposta do Bando de Dados que vai ser
    // consultado e que pode sauva e que pode listar.
    @RequestMapping(value = "lista", method = RequestMethod.GET) /*ele que vai definir que esse metodo para a
    resposta para a requisição Get no endpoint*/
    public ResponseEntity<List<Avaliacao>> lista(){
        return ResponseEntity.ok((List<Avaliacao>) avaliacaoRepository.findAll());/*ele que vai ser usado para buscar todas as avaliação do
    Bando de Dados*/
    }

    /*acima ele e para a criação e a definição do Endpoint*/
     @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)

     /*ele indica que os valores do parametro {id} na URL será passado a variaveis id no metodo*/
    public ResponseEntity<Avaliacao> getByid(@PathVariable (value = "id") Long id){

        /*no metodo findById(id) de repositorio que esta apontando para o avaliacaoRepository que esteja
        * esteja para buscar uma avaliação com o ID que vai ser informado*/
      Optional<Avaliacao> object = avaliacaoRepository.findById(id);

      /*ele vai faser uma verificação se o Objeto se ele vai existir com o codigo HTTP 200 ele vai
         mostrar como OK*/
      if(object.isPresent()){
          return new ResponseEntity<>(object.get(), HttpStatus.OK);
      }
      /*mas caso não exista ele vai retorna uma resposta com o estato 404 NOT_FOUND*/
      return new ResponseEntity<>(NOT_FOUND);
    }

     @RequestMapping (value= "atualizar/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Avaliacao> atualizar(@PathVariable (value = "id") Long id, @RequestBody Avaliacao avaliacao){
      if(!avaliacaoRepository.existsById(id)){
          return new ResponseEntity<>(NOT_FOUND);
      }
      avaliacao.setId(id);
      return new ResponseEntity<>(avaliacaoRepository.save(avaliacao), HttpStatus.OK);
    }

        @RequestMapping (value= "novo", method = RequestMethod.POST)
    public ResponseEntity<Avaliacao> novo(@RequestBody Avaliacao avaliacao){
     return new ResponseEntity<>(avaliacaoRepository.save(avaliacao), HttpStatus.OK);
    }

    @RequestMapping (value= "deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Avaliacao> deletar(@PathVariable (value = "id") Long id){
      if(!avaliacaoRepository.existsById(id)){
          return new ResponseEntity<>(NOT_FOUND);
      }
      avaliacaoRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
   
}
