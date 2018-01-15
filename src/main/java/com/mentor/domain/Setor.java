package com.mentor.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Setor implements Serializable { 
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	
	@ManyToOne
	@JoinColumn(name="subsecao_id")
	private Subsecao subsecao;
	
	@JsonIgnore
	@OneToMany(mappedBy="setor")
	private List<Demanda> demandasSetor = new ArrayList<>();

	
	public Setor() {
		
	}

	public Setor(Integer id, String nome, Subsecao subsecao) {
		super();
		this.id = id;
		this.nome = nome;
		this.subsecao = subsecao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Subsecao getSubsecao() {
		return subsecao;
	}

	public void setSubsecao(Subsecao subsecao) {
		this.subsecao = subsecao;
	}
	
	/**
	 * @return the demandasSetor
	 */
	public List<Demanda> getDemandasSetor() {
		return demandasSetor;
	}

	/**
	 * @param demandasSetor the demandasSetor to set
	 */
	public void setDemandasSetor(List<Demanda> demandasSetor) {
		this.demandasSetor = demandasSetor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
