package com.mentor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

}
