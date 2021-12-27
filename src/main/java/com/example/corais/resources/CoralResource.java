package com.example.corais.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.corais.domain.Coral;

@RestController
@RequestMapping(value="/corais")
public class CoralResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Coral> listar() {
		Coral c1 = new Coral(1, "Ars Cantandi");
		Coral c2 = new Coral(2, "Novos Cantos");
		List<Coral> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		return lista;
	}
}
