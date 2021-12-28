package com.example.corais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corais.domain.Cantor;

@Repository
public interface CantorRepository extends JpaRepository<Cantor, Integer> {

}
