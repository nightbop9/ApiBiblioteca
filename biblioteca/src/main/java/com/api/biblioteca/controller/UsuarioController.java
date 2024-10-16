package com.api.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.biblioteca.dto.UsuarioDTO;
import com.api.biblioteca.model.UsuarioModel;
import com.api.biblioteca.repository.UsuarioRepository;

@RestController
@RequestMapping("biblioteca")
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @PostMapping("/cadastrar") //Cadastrar um usuário
public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioDTO user) {
    if (user.nome() == null || user.livro() == null) {
        return ResponseEntity.badRequest().body("Nome e livro são obrigatórios.");
    }
        UsuarioModel usuario = new UsuarioModel(user); //// O objeto usuarioDTO contém os dados enviados pelo cliente
        repository.save(usuario); // Agora o DTO é convertido para a Model e salvo no banco
        return ResponseEntity.ok("Usuário cadastrado.");
    }

    @GetMapping("/listar") //Mostrar todos os usuários
    public List<UsuarioModel> listartudo(){
        return repository.findAll();
    }

    @GetMapping("/listar/{id}") //Mostrar usuário por id
    public ResponseEntity<UsuarioModel> listarid(@PathVariable Long id){
        return repository.findById(id)
            .map(ResponseEntity::ok) // Retorna status 200 com o usuário
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com o ID: " + id));   
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO user) {
        // Verifica se o usuário existe no banco de dados
        Optional<UsuarioModel> usuarioExistente = repository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioModel usuarioAtualizado = usuarioExistente.get(); // Recupera o objeto existente do banco

            // Atualiza os atributos do objeto existente com os dados fornecidos
            usuarioAtualizado.setNome(user.nome());
            usuarioAtualizado.setLivro(user.livro());
            usuarioAtualizado.setDescricao(user.descricao());

            // Salva o objeto atualizado no banco de dados
            repository.save(usuarioAtualizado);

            return ResponseEntity.ok("Usuário atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
    
        Optional<UsuarioModel> usuarioExistente = repository.findById(id);

        if (usuarioExistente.isPresent()) {
            repository.deleteById(id); // Remove o usuário do banco
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
    }

    }
    
    
