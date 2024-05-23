package com.joao.bookstore.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.joao.bookstore.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	@NotEmpty(message = "Campo nome obrigatório")
	@Length(min = 3, max = 100, message = "Campo deve ter no min 10 e no máximo 100")
	private String nome;
	
	@NotEmpty(message = "Campo descricao obrigatório")
	@Length@Length(min = 3, max = 200, message = "Campo deve ter no min 10 e no máximo 100")
	private String descricao;
	
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
}
