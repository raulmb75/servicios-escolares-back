package com.backendserviciosescolares.springboot.repositoryEscolares;

import com.backendserviciosescolares.springboot.entityEscolares.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository <Carrera, Integer> {

  @Query(value = "FROM Carrera WHERE nivelEscolar = ?1")
  List<Carrera> buscarCarreraPorNivelEscolar(Character nivelEscolar);
  @Query(value = "FROM Carrera WHERE nombreCarrera = ?1")
  List<Carrera> buscarCarreraPorNombre(String carrera);

  @Query(value = "FROM Carrera WHERE creditosTotales = ?1")
  List<Carrera> buscarCarreraPorCreditos(int creditos);

}
