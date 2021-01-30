package com.williambohn.orange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williambohn.orange.model.PessoaModel;
import com.williambohn.orange.repository.ApostaRepository;
import com.williambohn.orange.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	@Autowired
	private ApostaRepository apostaRepository;

	@Autowired
	private ApostaService service;

	
	public PessoaModel find(Integer id) {
		Optional<PessoaModel> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public PessoaModel findEmail(String email) {
		Optional<PessoaModel> obj = Optional.of(repo.findByEmail(email));
		return obj.orElse(null);
	}
	

	public PessoaModel insertPessoa(PessoaModel obj) {
		return repo.save(obj);
	}

	public List<PessoaModel> findAll() {
		return repo.findAll();
	}

}
