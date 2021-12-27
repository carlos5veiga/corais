package com.example.corais.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/corais")
public class CoralResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando";
	}
}
