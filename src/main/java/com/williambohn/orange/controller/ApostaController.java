package com.williambohn.orange.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.williambohn.orange.model.ApostaModel;
import com.williambohn.orange.model.PessoaModel;
import com.williambohn.orange.service.ApostaService;
import com.williambohn.orange.service.PessoaService;

@RestController
@RequestMapping(value = "/aposta")
public class ApostaController {

	@Autowired
	private ApostaService apostaService;

	@Autowired
	private PessoaService service;

	@GetMapping(path = "/{email}")
	public ResponseEntity<?> find(@PathVariable String email) {
		PessoaModel obj = service.findEmail(email);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(path = "/pessoa")
	public ResponseEntity<Void> insert(@RequestBody PessoaModel obj, ApostaModel aposta) {
		aposta = new ApostaModel(null, obj);
		obj = service.insertPessoa(obj);
		apostaService.insertAposta(aposta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<?> find(PessoaModel pessoa) {
		List<PessoaModel> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

}
