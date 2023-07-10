package com.backendserviciosescolares.springboot.controller;


import com.backendserviciosescolares.springboot.entity.Grupos;
import com.backendserviciosescolares.springboot.service.GruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
public class GruposController {

  @Autowired
  private GruposService gruposService;


  @GetMapping(value = "/carrera/{reticula}")
  public List<Grupos> buscarGruposPorCarrera(@PathVariable Integer reticula){
    return gruposService.buscarGruposPorCarrera(reticula);
  }

  @GetMapping(value = "/carrera/periodo/{reticula}/{periodo}")
  public List<Grupos> buscarGruposPorCarreraYperiodo(@PathVariable Integer reticula, String periodo){
      return gruposService.buscarGruposPorCarreraYperiodo(reticula, periodo);
    }

}
