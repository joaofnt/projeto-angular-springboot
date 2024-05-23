package com.joao.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="Categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo nome obrigatório")
	@Length(min = 3, max = 100, message = "Campo deve ter no min 10 e no máximo 100")
	private String nome;
	
	@NotEmpty(message = "Campo descricao obrigatório")
	@Length@Length(min = 3, max = 200, message = "Campo deve ter no min 10 e no máximo 100")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();
}
