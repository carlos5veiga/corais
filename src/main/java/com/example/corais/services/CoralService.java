package com.example.corais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.corais.domain.Coral;
import com.example.corais.dto.CoralDTO;
import com.example.corais.repositories.CoralRepository;
import com.example.corais.services.exceptions.DataIntegrityException;
import com.example.corais.services.exceptions.ObjectNotFoundException;

@Service
public class CoralService {

	@Autowired
	private CoralRepository repo;
	
	public Coral find(Integer id) {
		Optional<Coral> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id +
				", Tipo: " + Coral.class.getName()));
	}
	
	public Coral insert(Coral obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Coral update(Coral obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um coral que possui cantores");
		}
	}
	
	public List<Coral> findAll(){
		return repo.findAll();
	}
	
	public Page<Coral> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Coral fromDto(CoralDTO objDto) {
		return new Coral(objDto.getId(), objDto.getNome());
	}
}
