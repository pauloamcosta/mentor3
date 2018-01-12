package com.mentor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mentor.domain.Categoria;
import com.mentor.domain.Demanda;
import com.mentor.domain.Setor;
import com.mentor.domain.Subsecao;
import com.mentor.repository.CategoriaRepository;
import com.mentor.repository.DemandaRepository;
import com.mentor.repository.SetorRepository;
import com.mentor.repository.SubsecaoRepository;

@SpringBootApplication


public class Mentor3Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private DemandaRepository demandaRepository;
	@Autowired
	private SubsecaoRepository subsecaoRepository;
	@Autowired
	private SetorRepository setorRepository;

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

		
		Subsecao sub1 = new Subsecao(null, "Natal");
		Subsecao sub2 = new Subsecao(null, "Ceará Mirim");	
		Subsecao sub3 = new Subsecao(null, "Caicó");
		Subsecao sub4 = new Subsecao(null, "Assu");
		Subsecao sub5 = new Subsecao(null, "Mossoró");
		Subsecao sub6 = new Subsecao(null, "Pau dos Ferros");
		
		Setor s1 = new Setor(null, "1ª Vara", sub1);
		Setor s2 = new Setor(null, "2ª Vara", sub1);
		Setor s3 = new Setor(null, "3ª Vara", sub1);
		Setor s4 = new Setor(null, "4ª Vara", sub1);
		Setor s5 = new Setor(null, "5ª Vara", sub1);
		Setor s6 = new Setor(null, "6ª Vara", sub1);
		Setor s7 = new Setor(null, "7ª Vara", sub1);
		Setor s8 = new Setor(null, "8ª Vara", sub5);
		Setor s9 = new Setor(null, "9ª Vara", sub3);
		Setor s10 = new Setor(null, "10ª Vara", sub5);
		Setor s11 = new Setor(null, "11ª Vara", sub4);
		Setor s12 = new Setor(null, "12ª Vara", sub6);
		Setor s13 = new Setor(null, "13ª Vara", sub5);
		Setor s14 = new Setor(null, "14ª Vara", sub1);
		Setor s15 = new Setor(null, "15ª Vara", sub2);
		
		sub1.getSetores().addAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s14));
		sub2.getSetores().addAll(Arrays.asList(s15));
		sub3.getSetores().addAll(Arrays.asList(s9));
		sub4.getSetores().addAll(Arrays.asList(s11));
		sub5.getSetores().addAll(Arrays.asList(s8,s10,s13));
		sub6.getSetores().addAll(Arrays.asList(s12));
		
		subsecaoRepository.save(Arrays.asList(sub1,sub2,sub3,sub4,sub5,sub6));
		setorRepository.save(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15));
	}
	

	}

