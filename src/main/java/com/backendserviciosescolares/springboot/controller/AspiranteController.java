package com.backendserviciosescolares.springboot.controller;

import com.backendserviciosescolares.springboot.dto.AvisoEstudianteDTO;
import com.backendserviciosescolares.springboot.dto.FichaAspiranteDTO;
import com.backendserviciosescolares.springboot.entity.Aspirante;
import com.backendserviciosescolares.springboot.service.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AspiranteController {

  @Autowired
  private AspiranteService aspiranteService;

  @GetMapping("/aspirantes")
  public List<Aspirante> getAllAspirantes() {
    return aspiranteService.getAllAspirantes();
  }

  @GetMapping(value = "/aspirantes/{curp}")
  public Aspirante obtenerAspirantePorCurp(@PathVariable String curp){
    return aspiranteService.obtenerAspirantePorCurp(curp);
  }

  @GetMapping("/generar/ficha/{curp}")
  public List<FichaAspiranteDTO> buscarDatosFichaAspirante(@PathVariable String curp) {
    //System.out.println(noDeControl);
    return aspiranteService.buscarDatosFichaAspirante(curp);
  }
}
