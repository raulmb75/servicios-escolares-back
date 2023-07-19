package com.backendserviciosescolares.springboot.controller;


import com.backendserviciosescolares.springboot.entity.Carrera;
import com.backendserviciosescolares.springboot.service.CarreraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "carrera")
public class CarreraController {

  private final CarreraService carreraService;

  public CarreraController(CarreraService carreraService) {
    this.carreraService = carreraService;
  }

  @GetMapping
  public List<Carrera> mostrarCarreras(){
    return carreraService.buscarTodasCarreras();
  }

  @GetMapping(value = "/{reticula}")
  public Carrera mostrarCarreraPorReticula(@PathVariable Integer reticula){
    return carreraService.buscarCarreraPorReticula(reticula);
  }

  @GetMapping(value = "/nombre/{nombre}")
  public List<Carrera> mostrarCarreraPorNombre(@PathVariable String nombre){
    return carreraService.buscarCarreraPorNombre(nombre);
  }

  @GetMapping(value = "/nivel-escolar/{nivel}")
  public List<Carrera> mostrarCarrerasPorNivelEscolar(@PathVariable Character nivel){
    return carreraService.buscarCarreraPorNivelEscolar(nivel);
  }

  @GetMapping(value = "/creditos/{creditos}")
  public List<Carrera> mostrarCarrerasPorCreditos(@PathVariable Integer creditos){
    return carreraService.buscarCarreraPorCreditosTotales(creditos);
  }

}
