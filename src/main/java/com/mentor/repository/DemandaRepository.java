package com.mentor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.domain.Demanda;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda, Integer> {

}
