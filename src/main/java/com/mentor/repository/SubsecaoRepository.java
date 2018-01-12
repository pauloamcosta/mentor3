package com.mentor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.domain.Subsecao;

@Repository
public interface SubsecaoRepository extends JpaRepository<Subsecao, Integer> {

}
