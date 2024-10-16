package com.api.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.biblioteca.model.UsuarioModel;

//Interface que define o repositório para a entidade UsuarioModel.
//Extende JpaRepository, que fornece métodos prontos para operações CRUD (Create, Read, Update, Delete).
public interface UsuarioRepository extends JpaRepository <UsuarioModel, Long> {
	 // Não é necessário implementar nenhum método aqui, pois JpaRepository já fornece métodos
}
