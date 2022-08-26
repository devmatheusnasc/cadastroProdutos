package com.matheuscruz.cadastro.domain.tyoe;

public enum TipoCadastro {
	
	PRODUTO("P"),
	SERVICO("S");
	
	private char descricao;
	
	private TipoCadastro(String descricao) {
		this.descricao = descricao.charAt(0);
	}

	public char getDescricao () {
		return descricao;
	}
	
	public static TipoCadastro toStrings(String descricao) {
		
		if (descricao == null) {
			return null;
		}
		
		for (TipoCadastro x : TipoCadastro.values()) {
			if (descricao.equals(x.getDescricao())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Cadastro Inválido! ");
	}
		  
}
