package com.joao.bookstore.dtos;

import java.io.Serializable;

import com.joao.bookstore.domain.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String nome_autor;
	private String texto;
	
	public LivroDTO(Livro obj) {
		this.id = (obj.getId());
		this.titulo = (obj.getTitulo());
		this.nome_autor = (obj.getNome_autor());
		this.texto = (obj.getTexto());
	}
}
