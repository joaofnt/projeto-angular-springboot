package com.joao.bookstore.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="Livro")
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo titulo não pode ser vazio")
	@Length(min = 3, max = 50, message="Campo não pode passar de 50 carcteres")
	private String titulo;
	
	@NotEmpty(message = "Campo nome do autor não pode ser vazio")
	@Length(min = 5, max = 100, message="Campo não pode passar de 100 carcteres")
	private String nome_autor;
	
	@NotEmpty(message = "Campo texto não pode ser vazio")
	@Length(min = 5, max = 2000, message="Campo não pode passar de 2000 carcteres")
	private String texto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria; 
}
