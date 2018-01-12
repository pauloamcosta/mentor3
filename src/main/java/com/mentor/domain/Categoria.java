package com.mentor.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	
	@JsonManagedReference
	@ManyToMany(mappedBy="categorias") //informando que o mapeamento foi feito do outro lado
	private List<Demanda> demandas = new ArrayList<>(); //fazendo a associação de uma categoria ter várias demandas
	
	public Categoria() {
		
	}
	public Categoria(Integer id, String nome) {
		super();
		Id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the demandas
	 */
	public List<Demanda> getDemandas() {
		return demandas;
	}
	/**
	 * @param demandas the demandas to set
	 */
	public void setDemandas(List<Demanda> demandas) {
		this.demandas = demandas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}

