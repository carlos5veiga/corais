package com.example.corais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corais.domain.Coral;

@Repository
public interface CoralRepository extends JpaRepository<Coral, Integer> {

}
