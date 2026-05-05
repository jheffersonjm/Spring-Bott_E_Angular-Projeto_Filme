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

import br.com.jhefferson.filmes.model.Genero;
import br.com.jhefferson.filmes.repositorio.GeneroRepository;

@RestController
@RequestMapping (value = "genero")
public class GeneroController {
 @Autowired
    GeneroRepository generoRepository;

 @RequestMapping(value = "lista", method = RequestMethod.GET)
    public ResponseEntity<List<Genero>> listar(){
     return ResponseEntity.ok((List<Genero>) generoRepository.findAll());
 }

 @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Genero> getByid(@PathVariable (value = "id") Long id){
      Optional<Genero> object = generoRepository.findById(id);
      if(object.isPresent()){
          return new ResponseEntity<>(object.get(), HttpStatus.OK);
      }
      return new ResponseEntity<>(NOT_FOUND);
    }

    @RequestMapping (value= "atualizar/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Genero> atualizar(@PathVariable (value = "id") Long id, @RequestBody Genero genero){
      if(!generoRepository.existsById(id)){
          return new ResponseEntity<>(NOT_FOUND);
      }
      genero.setId(id);
      return new ResponseEntity<>(generoRepository.save(genero), HttpStatus.OK);
    }

    @RequestMapping (value= "novo", method = RequestMethod.POST)
    public ResponseEntity<Genero> novo(@RequestBody Genero genero){
     return new ResponseEntity<>(generoRepository.save(genero), HttpStatus.OK);
    }
}
