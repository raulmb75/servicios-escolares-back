package com.backendserviciosescolares.springboot.repository;

import com.backendserviciosescolares.springboot.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, String> {

  @Query(value = "FROM Personal p WHERE p.claveArea.claveArea = ?1")
  List<Personal> buscarPersonalPorClaveArea(String claveArea);
  @Query(value = "FROM Personal WHERE lugarNacimiento = ?1")
  List<Personal> buscarPersonalPorLugarNacimiento(Integer lugarNacimiento);
  @Query(value = "FROM Personal WHERE gradoMaximoEstudios = ?1")
  List<Personal> buscarPersonalPorGradoMaxEstudios(String gradoMaxEstudios);
  @Query(value = "FROM Personal WHERE sexoEmpleado = ?1")
  List<Personal> buscarPersonalPorSexo(Character sexo);
  @Query(value = "FROM Personal WHERE localidad = ?1")
  List<Personal> buscarPersonalPorLocalidad(String localidad);
  @Query(value = "FROM Personal WHERE estatusEmpleado = ?1")
  List<Personal> buscarPersonalPorStatusEmpleado(String statusEmpleado);

}
