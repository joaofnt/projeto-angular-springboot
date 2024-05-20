package com.joao.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
	private Long id;
	private String titulo;
	private String nome_autor;
	private String texto;
	
	private Categoria categoria; 
}
