/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.jhefferson.filmes.controller;

import java.util.List;
import java.util.Optional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhefferson.filmes.model.Usuario;
import br.com.jhefferson.filmes.repositorio.Usuariorepository;
// não esta pronta tem uqe fazer algumas modificação.
// não vai rodar o rpograma ainda mão esta conpleto.

/**
 *
 * @author jhefferson.7980
 */
@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {

    @Autowired
    Usuariorepository Usuariorepository;
@RequestMapping (value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> lista(){
        return ResponseEntity.ok((List<Usuario>) Usuariorepository.findAll());
}

@RequestMapping (value= "listar/{id}", method= RequestMethod.GET)
public ResponseEntity<Usuario> getByid(@PathVariable (value= "id") Long id){ 
    Optional<Usuario> usuario = Usuariorepository.findById(id);
    if(usuario.isPresent()){ 
        return ResponseEntity.ok(usuario.get());
    }
    return ResponseEntity.notFound().build();
}

@RequestMapping (value= "atualizar/{id}", method= RequestMethod.PUT)
public ResponseEntity<Usuario> atualizar(@PathVariable(value="id") Long id, @RequestBody Usuario novoUsuario){ 
    Optional<Usuario> usuario= Usuariorepository.findById(id);
    if(usuario.isPresent()){ 
        return new ResponseEntity<>(Usuariorepository.save(novoUsuario), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

 @RequestMapping (value = "novo", method = RequestMethod.POST)
 public ResponseEntity<Usuario> novo(@RequestBody Usuario Usuario){
    return ResponseEntity.ok(Usuariorepository.save(Usuario));
 }
 @RequestMapping (value= "deletar/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<Usuario> deletar(@PathVariable (value = "id") Long id){
    if(!Usuariorepository.existsById(id)){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return null;
 }
} 

