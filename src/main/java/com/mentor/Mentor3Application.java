package com.mentor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mentor.domain.Categoria;
import com.mentor.domain.Demanda;
import com.mentor.repository.CategoriaRepository;
import com.mentor.repository.DemandaRepository;

@SpringBootApplication


public class Mentor3Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private DemandaRepository demandaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Mentor3Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
	
		
		Categoria cat1 = new Categoria(null, "Desenvolvimento");
		Categoria cat2 = new Categoria(null, "Infraestrutura");
		Categoria cat3 = new Categoria(null, "Business Intelligence");
		Categoria cat4 = new Categoria(null, "Indefinido");
		
		Demanda d1 = new Demanda(null, "Melhorias para o ambiente de TI", "Sarah Raquel", null, "Utilizar a Wiki do Gitlab para documentar os projetos, no lugar do portal do conhecimento",
				"24/11/2017", "01/12/2017", true, true, true, "Aguardando aplicação");
		Demanda d2 = new Demanda(null, "Acompanhamento de jurisprudência dos tribunais superiores", "Anna Patrícia", null, "Acompanhamento de jurisprudência dos tribunais superiores",
				"07/12/2017", "18/12/2017", true, true, true, "Aguardando imersão");		
		
		cat1.getDemandas().addAll(Arrays.asList(d1, d2));
		cat3.getDemandas().addAll(Arrays.asList(d2));
		
		d1.getCategorias().addAll(Arrays.asList(cat1));
		d2.getCategorias().addAll(Arrays.asList(cat1, cat3));
			
		
		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4));
		demandaRepository.save(Arrays.asList(d1,d2));

	}
	

	}

