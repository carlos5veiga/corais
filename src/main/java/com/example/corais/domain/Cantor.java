package com.example.corais.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cantor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="CANTOR_CORAL",
				joinColumns = @JoinColumn(name="cantor_id"),
				inverseJoinColumns = @JoinColumn(name="coral_id"))
	private List<Coral> listaCorais = new ArrayList<>();
	
	public Cantor() {
	}

	public Cantor(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Coral> getListaCorais() {
		return listaCorais;
	}

	public void setListaCorais(List<Coral> listaCorais) {
		this.listaCorais = listaCorais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cantor other = (Cantor) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
