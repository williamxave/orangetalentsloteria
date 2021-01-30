package com.williambohn.orange.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williambohn.orange.model.ApostaModel;
import com.williambohn.orange.repository.ApostaRepository;

@Service
public class ApostaService {

@Autowired
private ApostaRepository repo;
	
	public int geraNumero() {
		int valor = 0;
		Random gerador = new Random();
		for(int i = 0; i < 1;i++) {
			valor = gerador.nextInt();
			if(valor < 0) {
				valor *= -1;
			}
		}
		return  valor;

	}

	public ApostaModel insertAposta(ApostaModel aposta) {
		return repo.save(aposta);
	}
	
	public ApostaModel find(Integer id) {
		Optional<ApostaModel> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<ApostaModel> findAllModel() {
		return repo.findAll();
	}

	}
			

