package br.com.jhefferson.filmes.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhefferson.filmes.model.Obra;
import br.com.jhefferson.filmes.repositorio.ObraRepository;


@RestController// ele informa que essa classe é um controlador de requisições REST
@RequestMapping (value = "obra") // mapeia as requisições para o caminho /obra
public class ObraController {
@Autowired // injeção de dependência do repositório de obras
    ObraRepository obraRepository; // interface que fornece métodos para operações CRUD no banco de dados

 @RequestMapping(value = "lista", method = RequestMethod.GET) // mapeia as requisições GET para o caminho /obra/lista
    public ResponseEntity<List<Obra>> listar(){ // método que retorna uma lista de todas as obras
     return ResponseEntity.ok((List<Obra>) obraRepository.findAll()); // retorna a lista de obras com status HTTP 200 (OK)
 }

 @RequestMapping (value = "lista/{id}", method = RequestMethod.GET)
 public ResponseEntity <Obra> getByid(@PathVariable (value = "id") Long id){ 
    Optional<Obra> obra = obraRepository.findById(id);
    if(obra.isPresent()){ 
        return ResponseEntity.ok(obra.get());
    }
    return ResponseEntity.notFound().build();
 }

 @RequestMapping (value= "atualizar/{id}", method= RequestMethod.PUT)
 public ResponseEntity<Obra> atualizar(@PathVariable(value= "id") Long id, @RequestBody Obra novaObra){ 
    java.util.Optional<Obra> obra = obraRepository.findById(id);
    if(obra.isPresent()){ 
        return new ResponseEntity<>(obraRepository.save(novaObra), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
 @RequestMapping (value = "novo", method = RequestMethod.POST)
 public ResponseEntity<Obra> novo(@RequestBody Obra obra){
    return ResponseEntity.ok(obraRepository.save(obra));
}
@RequestMapping (value= "deletar/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<Obra> deletar(@PathVariable (value = "id") Long id){
    if(!obraRepository.existsById(id)){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    obraRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
 }
}
