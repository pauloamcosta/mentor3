package com.mentor.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.domain.Categoria;
import com.mentor.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
		
	//	Categoria cat1 = new Categoria(1, "Desenvolvimento");
		//Categoria cat2 = new Categoria(2, "Infraestrutura");
	//	Categoria cat3 = new Categoria(3, "Business Intelligence");
		//Categoria cat4 = new Categoria(4, "Indefinido");
		
		//List<Categoria> lista = new ArrayList<>();
		//lista.add(cat1);
	//	lista.add(cat2);
		//lista.add(cat3);
		//lista.add(cat4);
		
		
		//return lista;
		
	}

}
