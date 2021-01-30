package com.williambohn.orange.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "pessoa")
public class PessoaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String email;

	@OneToMany(mappedBy = "pessoa")
	private List<ApostaModel> aposta = new ArrayList<>();

	public PessoaModel() {
	}

	public PessoaModel(Integer id, String email) {
		this.id = id;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ApostaModel> getAposta() {
		return aposta;
	}

	public void setAposta(List<ApostaModel> aposta) {
		this.aposta = aposta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
