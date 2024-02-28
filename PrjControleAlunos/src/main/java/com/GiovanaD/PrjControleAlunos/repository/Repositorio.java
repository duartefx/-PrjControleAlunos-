package com.GiovanaD.PrjControleAlunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GiovanaD.PrjControleAlunos.entities.Principal;


public interface Repositorio extends JpaRepository <Principal, Long> {

}