package com.backendserviciosescolares.springboot.repository;

import com.backendserviciosescolares.springboot.entity.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AspiranteRepository extends JpaRepository <Aspirante, Long> {

  Aspirante findByCurp(String curp);
}
