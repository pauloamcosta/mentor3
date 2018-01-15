package com.mentor.domain.enums;

public enum TipoUsuario {
	
	RESIDENTE(1, "Residente"),
	SCRUMMASTER(2, "Scrum Master"),
	DIRETOR(3, "Diretor NTI");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoUsuario toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for (TipoUsuario x : TipoUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalAccessError("Id inválido: " + cod);
		
	}

}
