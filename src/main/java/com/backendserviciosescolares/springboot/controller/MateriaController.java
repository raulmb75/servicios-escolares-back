package com.backendserviciosescolares.springboot.controller;

import com.backendserviciosescolares.springboot.entity.Materia;
import com.backendserviciosescolares.springboot.service.MateriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "materias")
public class MateriaController {
  private final MateriaService materiaService;

  public MateriaController(MateriaService materiaService) {
    this.materiaService = materiaService;
  }

  @GetMapping
  public List<Materia> mostrarTodasMaterias(){
    return materiaService.buscarTodasMaterias();
  }

  @GetMapping(value = "/{claveMateria}")
  public Materia buscarMateriaPorClave(@PathVariable String claveMateria){
    return materiaService.buscarMateriaPorClave(claveMateria);
  }

  @PostMapping
  public ResponseEntity<Materia> registrarMateria(@RequestBody Materia materia){
    return new ResponseEntity<>(materiaService.registrarMateria(materia), HttpStatus.OK);
  }

  @PutMapping(value = "/{claveMateria}")
  public ResponseEntity<Materia> actualizarDatosMateria(@PathVariable String claveMateria,
                                                        @RequestBody Materia materia){
    return new ResponseEntity<>(materiaService.actualizarDatosMateria(claveMateria, materia), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{claveMateria}")
  public void eliminarMateria(@PathVariable String claveMateria){
    materiaService.eliminarMateria(claveMateria);
  }

  @GetMapping(value = "/nivel-escolar/{nivelEscolar}")
  public List<Materia> mostrarMateriaPorNivelEscolar(@PathVariable Character nivelEscolar){
    return materiaService.buscarMateriaPorNivelEscolar(nivelEscolar);
  }

  @GetMapping(value = "/area/{claveArea}")
  public List<Materia> mostrarMateriaPorDepartamento(@PathVariable String claveArea){
    return materiaService.buscarMateriaPorDepartamento(claveArea);
  }

  @GetMapping(value = "/tipo/{tipoMateria}")
  public List<Materia> mostrarMateriaPorTipo(@PathVariable Integer tipoMateria){
    return materiaService.buscarMateriaPorTipo(tipoMateria);
  }
}
