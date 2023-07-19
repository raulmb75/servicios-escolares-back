package com.backendserviciosescolares.springboot.repository;

import com.backendserviciosescolares.springboot.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MateriaRepository extends JpaRepository <Materia, String> {


  @Query(value = "FROM Materia m WHERE m.nivelEscolar.nivelEscolar = ?1")
  List<Materia> buscarMateriaPorNivelEscolar(Character nivelEscolar);

  @Query(value = "FROM Materia m WHERE m.claveArea.claveArea = ?1")
  List<Materia> buscarMateriaPorDepartamento(String claveArea);

  @Query(value = "FROM Materia m WHERE m.tipoMateria.tipoMateria = ?1")
  List<Materia> buscarMateriaPorTipo(Integer tipoMateria);

}
