package com.backendserviciosescolares.springboot.repository;

import com.backendserviciosescolares.springboot.entity.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GruposRepository extends JpaRepository<Grupos, Integer> {

  @Query(value = "FROM Grupos g WHERE g.reticula.reticula = ?1")
  List<Grupos> buscarGruposPorCarrera(Integer reticula);

}
