package com.joao.bookstore.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.bookstore.domain.Categoria;
import com.joao.bookstore.domain.Livro;
import com.joao.bookstore.repositories.CategoriaRepository;
import com.joao.bookstore.repositories.LivroRepository;

@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI", new ArrayList<>());
		Categoria cat2 = new Categoria(null, "Desenvolvimento Pessoal", "Livros sobre crescimento pessoal",new ArrayList<>());
		Categoria cat3 = new Categoria(null, "Negócios", "Livros sobre administração e empreendedorismo", new ArrayList<>());
		Categoria cat4 = new Categoria(null, "Romances", "Livros de ficção romântica", new ArrayList<>());

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren Ipsum", cat1);
		Livro l2 = new Livro(null, "O Poder do Hábito", "Charles Duhigg", "Explore o poder dos hábitos na vida pessoal e profissional", cat2);
		Livro l3 = new Livro(null, "Comece Pelo Porquê", "Simon Sinek", "Descubra como inspirar pessoas com sua causa", cat3);
		Livro l4 = new Livro(null, "Orgulho e Preconceito", "Jane Austen", "Um clássico atemporal sobre amor e sociedade", cat4);
		Livro l5 = new Livro(null, "Seja Forte", "De você", "Esse é o livro da sua superação", cat2);
		
        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
	
        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
