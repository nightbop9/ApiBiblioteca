package com.api.biblioteca.dto;
//Define um record chamado UsuarioDTO que representa um usuário com os seguintes atributos:
//- id: Um identificador único do tipo Long para o usuário.
//- nome: O nome do usuário do tipo String.
//- livro: O título do livro associado ao usuário, do tipo String.
//- descricao: Uma descrição adicional do usuário, do tipo String.
public record UsuarioDTO (Long id, String nome, String livro, String descricao) {
    //record são imutáveis
}
