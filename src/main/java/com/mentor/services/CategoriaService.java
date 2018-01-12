package com.mentor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.domain.Categoria;
import com.mentor.repository.CategoriaRepository;
import com.mentor.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if (obj == null) {
			
			throw new ObjectNotFoundException("Objeto Não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
		
	}
}
