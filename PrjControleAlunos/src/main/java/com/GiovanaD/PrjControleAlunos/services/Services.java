package com.GiovanaD.PrjControleAlunos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.GiovanaD.PrjControleAlunos.entities.Principal;
import com.GiovanaD.PrjControleAlunos.repository.Repositorio;

@Service
public class Services {
	
	private Repositorio principalRepositorio;
	
	public Services(Repositorio principalRepositorio) {
		this.principalRepositorio = principalRepositorio;
	}
	
	//preparando as buscas por id
	
	public Principal findPrincipalById(Long idAluno) {
		Optional <Principal> Principal = principalRepositorio.findById(idAluno);
		return Principal.orElse(null);
	}
	
	// preparando a busca geral
		public List<Principal> findAllPrincipal() {
			return principalRepositorio.findAll();
		}
		
	// salvando 
		public Principal insertPrincipal(Principal prin) {
			return principalRepositorio.save(prin);
		}
	
		
	// fazendo o update 
		public Principal updatePrincipal(Long idAluno, Principal novoPrincipal) {
			Optional<Principal> prinOptional = principalRepositorio.findById(idAluno);
				if (prinOptional.isPresent()) {
					Principal prinExistente = prinOptional.get();
					prinExistente.setName(novoPrincipal.getName());
					return principalRepositorio.save(prinExistente);
					} else {
						return null;
					}
				}
		
		// deletando
				public boolean deletePrincipal(Long idAluno) {
					Optional<Principal> prinExistente = principalRepositorio.findById(idAluno);
					if (prinExistente.isPresent()) {
						principalRepositorio.deleteById(idAluno);
						return true;
					} else {
						return false;
					}
				}
	

}
