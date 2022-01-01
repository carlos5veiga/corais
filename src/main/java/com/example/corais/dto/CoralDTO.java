package com.example.corais.dto;

import java.io.Serializable;

import com.example.corais.domain.Coral;
//Este meu DTO possui os mesmos xxxxx que o Coral mas no caso de o Coral ter mais xxxxx, o DTO vai
//pegar apenas os que se deseja mostrar
public class CoralDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public CoralDTO() {
	}
	
	public CoralDTO(Coral obj) {
		id = obj.getId();
		nome = obj.getNome();
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
}
