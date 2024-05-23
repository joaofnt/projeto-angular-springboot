package com.joao.bookstore.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String fieldname;
	private String message;
	
}
