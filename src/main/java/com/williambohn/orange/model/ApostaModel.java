package com.williambohn.orange.model;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "aposta")
public class ApostaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer numerosLoto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private PessoaModel pessoa;

	public ApostaModel() {

	}

	public ApostaModel(Integer id, PessoaModel pessoa) {
		this.id = id;
		this.pessoa = pessoa;
		this.setNumerosLoto(this.geraNumero());
	}



	public int geraNumero() {
		int valor = 0;
		Random gerador = new Random();
		for (int i = 0; i < 1; i++) {
			valor = gerador.nextInt();
			if (valor < 0) {
				valor *= -1;
			}
		}
		return valor;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumerosLoto() {
		return numerosLoto;
	}

	public void setNumerosLoto(Integer numerosLoto) {
		this.numerosLoto = numerosLoto;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}
}
