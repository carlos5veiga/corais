package com.example.corais;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.corais.domain.Cantor;
import com.example.corais.domain.Coral;
import com.example.corais.repositories.CantorRepository;
import com.example.corais.repositories.CoralRepository;

@SpringBootApplication
public class CoraisApplication implements CommandLineRunner {

	@Autowired
	private CoralRepository coralRepository;
	
	@Autowired
	private CantorRepository cantorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CoraisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Coral cor1 = new Coral(null, "Ars Cantandi");
		Coral cor2 = new Coral(null, "Novos Cantos");
		Coral cor3 = new Coral(null, "Pentágono");
		Coral cor4 = new Coral(null, "Bahiana");
		Coral cor5 = new Coral(null, "Câmara");
		Coral cor6 = new Coral(null, "FIEB");
		Coral cor7 = new Coral(null, "CIMATEC");
		
		Cantor cant1 = new Cantor(null, "Valcy");
		Cantor cant2 = new Cantor(null, "Babita");
		Cantor cant3 = new Cantor(null, "Augustao");
		
		cor1.getListaCantores().addAll(Arrays.asList(cant1, cant3));
		cor2.getListaCantores().addAll(Arrays.asList(cant1, cant2));
		
		cant1.getListaCorais().addAll(Arrays.asList(cor1, cor2));
		cant2.getListaCorais().addAll(Arrays.asList(cor2));
		cant3.getListaCorais().addAll(Arrays.asList(cor1));
		
		coralRepository.saveAll(Arrays.asList(cor1, cor2, cor3, cor4, cor5, cor6, cor7));
		cantorRepository.saveAll(Arrays.asList(cant1, cant2, cant3));
		
	}

}
