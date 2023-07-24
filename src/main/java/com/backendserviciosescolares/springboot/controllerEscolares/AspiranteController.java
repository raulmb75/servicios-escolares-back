package com.backendserviciosescolares.springboot.controllerEscolares;

import com.backendserviciosescolares.springboot.dtoEscolares.FichaAspiranteDTO;
import com.backendserviciosescolares.springboot.entityEscolares.Aspirante;
import com.backendserviciosescolares.springboot.serviceEscolares.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="escolares/aspirantes")
public class AspiranteController {

  @Autowired
  private AspiranteService aspiranteService;

  @GetMapping("/obtener/todos/aspirantes")
  public List<Aspirante> getAllAspirantes() {
    return aspiranteService.getAllAspirantes();
  }

  @GetMapping(value = "/obtener/aspirantes/{curp}")
  public Aspirante obtenerAspirantePorCurp(@PathVariable String curp){
    return aspiranteService.obtenerAspirantePorCurp(curp);
  }

  @GetMapping("/generar/ficha/{curp}")
  public List<FichaAspiranteDTO> buscarDatosFichaAspirante(@PathVariable String curp) {
    //System.out.println(noDeControl);
    return aspiranteService.buscarDatosFichaAspirante(curp);
  }
}
