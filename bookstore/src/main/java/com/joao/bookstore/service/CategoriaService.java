package com.joao.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.joao.bookstore.domain.Categoria;
import com.joao.bookstore.dtos.CategoriaDTO;
import com.joao.bookstore.repositories.CategoriaRepository;
import com.joao.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Long id, CategoriaDTO objdto) {
		Categoria obj = findById(id);
		obj.setNome(objdto.getNome());
		obj.setDescricao(objdto.getDescricao());
	
		return categoriaRepository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.joao.bookstore.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletado, possui livros associados");
		}
	}
}
