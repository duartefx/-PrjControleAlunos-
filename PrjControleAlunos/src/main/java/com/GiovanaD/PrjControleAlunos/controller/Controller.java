package com.GiovanaD.PrjControleAlunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GiovanaD.PrjControleAlunos.entities.Principal;
import com.GiovanaD.PrjControleAlunos.services.Services;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name="controle", description = "API REST DE CONTROLE DE ANULOS")
@RestController
@RequestMapping("/alunos")
public class Controller {

	private final Services principalService;

	@Autowired
	public Controller(Services principalService) {
		this.principalService = principalService;
	}

	//procurar pelo id
	@GetMapping("/{idAluno}")
	@Operation(summary = "Localiza usuário por ID")
	public ResponseEntity<Principal> findDepartamentobyId(@PathVariable Long idAluno) {
		Principal principal = principalService.findPrincipalById(idAluno);
		if (principal != null) {
			return ResponseEntity.ok(principal);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//procurar
			@GetMapping("/")
			@Operation(summary ="Apresentar")
			public ResponseEntity<List<Principal>> findAllPrincipalcontrol() {
				List<Principal> deps = principalService.findAllPrincipal();
				return ResponseEntity.ok(deps);
			}
			

			//insert
			@PostMapping("/")
			@Operation(summary = "Cadastra")
			public ResponseEntity<Principal> insertPrincipalControl(@RequestBody @Valid Principal principal) {
				Principal novoPrin = principalService.insertPrincipal(principal);
				return ResponseEntity.status(HttpStatus.CREATED).body(principal);
			}

		
			//update
			@PutMapping("/{idAluno}")
			@Operation(summary = "Alterar")
			public ResponseEntity<Principal> updateDepartamentoControl(@PathVariable Long idAluno, @RequestBody @Valid Principal principal) {
				Principal mudaPrin = principalService.updatePrincipal(idAluno, principal);
				if (mudaPrin != null) {
					return ResponseEntity.ok(principal);
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			
			//deletar
			@DeleteMapping("/{idAluno}")
			@Operation(summary = "Excluir")
			public ResponseEntity<String> deletePrincipalControl(@PathVariable Long idAluno) {
				boolean remover = principalService.deletePrincipal(idAluno);
				if (remover) {
					return ResponseEntity.ok().body("Excluído com sucesso");
				} else {
					return ResponseEntity.notFound().build();
				}
			}

}
