package com.GiovanaD.PrjControleAlunos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "controle")
public class Principal {

	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String endereco;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	
	
	//getts
	
	public void getId(Long idAluno) {
		this.idAluno = idAluno;
	}
	
	public String getName() {
		return null;
	}
	
	public void getCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void getRg(String rg) {
		this.rg = rg;
	}
	
	public void getEnd(String endereco) {
		this.endereco = endereco;
	}
	
	
	//setts
	
	public void setEnd(String endereco) {
		this.endereco = endereco;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	public void setId(Long idAluno) {
		this.idAluno = idAluno;
	}

	
	
	
}
