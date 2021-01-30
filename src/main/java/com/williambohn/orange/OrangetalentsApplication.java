package com.williambohn.orange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.williambohn.orange.repository.ApostaRepository;
import com.williambohn.orange.repository.PessoaRepository;

@SpringBootApplication
public class OrangetalentsApplication implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ApostaRepository apostaRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrangetalentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	PessoaModel p1 = new PessoaModel(null,"xaxa@testando");
		ApostaModel ap1 = new ApostaModel(null,p1);
		
		p1.getAposta().addAll(Arrays.asList(ap1));
		
		pessoaRepository.saveAll(Arrays.asList(p1));
		apostaRepository.saveAll(Arrays.asList(ap1));
		
		
	}
	*/

}
}
