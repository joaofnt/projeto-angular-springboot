package com.joao.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.bookstore.domain.Categoria;
import com.joao.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
}
