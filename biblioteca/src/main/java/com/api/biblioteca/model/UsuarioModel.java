package com.api.biblioteca.model;

import com.api.biblioteca.dto.UsuarioDTO;  // Importa a classe UsuarioDTO, que representa o objeto de transferência de dados.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class UsuarioModel {
    private String nome;
    private String livro;
    private String descricao;
 
    public UsuarioModel(){
    }
    // Construtor que recebe um UsuarioDTO e inicializa os atributos do modelo.
    public UsuarioModel(UsuarioDTO user) {
        this.nome = user.nome();
        this.livro = user.livro();
        this.descricao = user.descricao();
    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLivro() {
		return livro;
	}
	public void setLivro(String livro) {
		this.livro = livro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    
}
