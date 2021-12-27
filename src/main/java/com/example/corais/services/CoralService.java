package com.example.corais.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corais.domain.Coral;
import com.example.corais.repositories.CoralRepository;

@Service
public class CoralService {

	@Autowired
	private CoralRepository repo;
	
	public Coral buscar(Integer id) {
		Optional<Coral> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
