package com.backendserviciosescolares.springboot.repositoryEscolares;

import com.backendserviciosescolares.springboot.entityEscolares.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GruposRepository extends JpaRepository<Grupos, Integer> {

  //buscar por reticula
  @Query(value = "FROM Grupos g WHERE g.reticula.reticula = ?1")
  List<Grupos> buscarGruposPorCarrera(Integer reticula);

  //buscar por reticula y periodo
  @Query(value = "FROM Grupos AS g WHERE  g.reticula.reticula = ?1 AND g.periodo.periodo = ?2 ")
  List<Grupos> buscarGruposPorCarreraYperiodo(Integer reticula, String periodo);
}
