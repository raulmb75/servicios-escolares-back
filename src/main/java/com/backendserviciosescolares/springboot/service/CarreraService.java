package com.backendserviciosescolares.springboot.service;

import com.backendserviciosescolares.springboot.entity.Carrera;
import com.backendserviciosescolares.springboot.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarreraService {
  private final CarreraRepository carreraRepository;

  public CarreraService(CarreraRepository carreraRepository) {
    this.carreraRepository = carreraRepository;
  }

  public List<Carrera> buscarTodasCarreras(){
    return carreraRepository.findAll();
  }

  public Carrera buscarCarreraPorReticula(Integer reticula){
    Carrera carrera = carreraRepository.findById(reticula)
      .orElseThrow(()->
        new EntityNotFoundException("Carrera con retícula " + reticula + " no encontrada"));

    return carrera;
  }

  public List<Carrera> buscarCarreraPorNivelEscolar(Character nivelEscolar){
    return carreraRepository.buscarCarreraPorNivelEscolar(nivelEscolar);
  }

  public List<Carrera> buscarCarreraPorNombre(String nombre){
    return carreraRepository.buscarCarreraPorNombre(nombre);
  }

  public List<Carrera> buscarCarreraPorCreditosTotales(int creditos){
    return carreraRepository.buscarCarreraPorCreditos(creditos);
  }
}
