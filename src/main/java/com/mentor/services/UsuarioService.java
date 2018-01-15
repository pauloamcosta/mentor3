package com.mentor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.domain.Usuario;
import com.mentor.repository.UsuarioRepository;
import com.mentor.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	public Usuario buscar(Integer id) {
		Usuario obj = repo.findOne(id);
		
		if (obj == null) {
			
			throw new ObjectNotFoundException("Objeto Não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
		
	}
}
