package com.joao.bookstore.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
	private Long timeStamp;
	private Integer status;
	private String error;
}
