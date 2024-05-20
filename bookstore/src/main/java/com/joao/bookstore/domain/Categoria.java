package com.joao.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	private Long id;
	private String nome;
	private String descricao;
	
	private List<Livro> livros = new ArrayList<>();
}
