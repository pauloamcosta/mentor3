package com.mentor.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Demanda implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String autor;
	private String email;
	private String descricao;
	private String dataRecebimento;
	private String data5dias;
	private Boolean feedInicial;
	private Boolean feed5dias;
	private Boolean publicadoMural;
	private String posicaoAtual;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="setor_id")
	private Setor setor;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuarioAgente;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "DEMANDA_CATEGORIA",
		joinColumns = @JoinColumn(name = "demanda_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
	) //fazendo mapeamento, definindo chave estrangeira
	
	private List<Categoria> categorias = new ArrayList<>(); //fazendo a associação de uma demanda ter uma ou mais categoria

	public Demanda() {
		
	}

	public Demanda(Integer id, String nome, String autor, String email, String descricao, String dataRecebimento, String data5dias, Boolean feedInicial,
			Boolean feed5dias, Boolean publicadoMural, String posicaoAtual, Setor setor, Usuario usuarioAgente) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.email = email;
		this.descricao = descricao;
		this.dataRecebimento = dataRecebimento;
		this.data5dias = data5dias;
		this.feedInicial = feedInicial;
		this.feed5dias = feed5dias;
		this.publicadoMural = publicadoMural;
		this.posicaoAtual = posicaoAtual;
		this.setor = setor;
		this.usuarioAgente = usuarioAgente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public String getData5dias() {
		return data5dias;
	}

	public void setData5dias(String data5dias) {
		this.data5dias = data5dias;
	}

	public Boolean getFeedInicial() {
		return feedInicial;
	}

	public void setFeedInicial(Boolean feedInicial) {
		this.feedInicial = feedInicial;
	}

	public Boolean getFeed5dias() {
		return feed5dias;
	}

	public void setFeed5dias(Boolean feed5dias) {
		this.feed5dias = feed5dias;
	}

	public Boolean getPublicadoMural() {
		return publicadoMural;
	}

	public void setPublicadoMural(Boolean publicadoMural) {
		this.publicadoMural = publicadoMural;
	}

	public String getPosicaoAtual() {
		return posicaoAtual;
	}

	public void setPosicaoAtual(String posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	

	public Usuario getUsuarioAgente() {
		return usuarioAgente;
	}

	public void setUsuarioAgente(Usuario usuarioAgente) {
		this.usuarioAgente = usuarioAgente;
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
		Demanda other = (Demanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
