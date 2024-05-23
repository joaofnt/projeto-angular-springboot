package com.joao.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.joao.bookstore.domain.Categoria;
import com.joao.bookstore.domain.Livro;
import com.joao.bookstore.dtos.LivroDTO;
import com.joao.bookstore.repositories.LivroRepository;
import com.joao.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findByid(Long id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " + id + ", tipo " + Livro.class.getName()));
	}
	
	public List<Livro> findAll(Long id_cat){
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro create(Long id_cat,Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}
	
	public Livro update(Long id, LivroDTO livro) {
		Livro obj = findByid(id);
		obj.setNome_autor(livro.getNome_autor());
		obj.setTexto(livro.getTexto());
		obj.setTitulo(livro.getTitulo());
		return livroRepository.save(obj);
			
	}

	public void delete(Long id) {
		Livro obj = findByid(id);
		try {
			livroRepository.delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new com.joao.bookstore.service.exceptions.DataIntegrityViolationException("Livro  não pode ser deletado, possui categoria associada");
		}
		
	}
	
	
}
