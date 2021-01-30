package com.williambohn.orange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.williambohn.orange.model.ApostaModel;

@Repository
public interface ApostaRepository extends JpaRepository<ApostaModel, Integer> {


}
