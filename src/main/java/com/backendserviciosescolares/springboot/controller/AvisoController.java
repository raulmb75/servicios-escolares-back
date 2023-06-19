package com.backendserviciosescolares.springboot.controller;

import com.backendserviciosescolares.springboot.dto.AvisoEstudianteDTO;
import com.backendserviciosescolares.springboot.dto.RequesAviso;
import com.backendserviciosescolares.springboot.entity.AvisoEstudiante;
import com.backendserviciosescolares.springboot.entity.Estudiante;
import com.backendserviciosescolares.springboot.repository.AvisoEstudianteRelacionRepository;
import com.backendserviciosescolares.springboot.repository.AvisoRepository;
import com.backendserviciosescolares.springboot.service.AvisoEstudianteRelacionService;
import com.backendserviciosescolares.springboot.service.AvisoService;
import com.backendserviciosescolares.springboot.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@Controller
@RequestMapping("/avisos")
public class AvisoController {


  private AvisoService avisoService;

  @Autowired
  private AvisoEstudianteRelacionRepository avisoEstudianteRelacionRepository;

  @Autowired
  private AvisoRepository avisoRepository;
  @Autowired
  private AvisoEstudianteRelacionService avisoEstudianteRelacionService;
  @Autowired
  private EstudianteService estudianteService;

  public AvisoController(AvisoService avisoService) {
    this.avisoService = avisoService;
  }

 /*@PostMapping("/enviar/mensaje")
  public AvisoEstudiante saveMessage(@RequestBody RequesAviso requesAviso) {
    System.out.println(requesAviso.getNoControl() + requesAviso.getVigencia() + requesAviso.getMensaje());
    String[] noControl = requesAviso.getNoControl().split(",");

    AvisoEstudiante aviso = avisoService.enviarMensaje(requesAviso.getMensaje(), requesAviso.getVigencia());
    for (int i = 0; i < noControl.length; i++) {
      Estudiante estudiante =
      avisoEstudianteRelacionService.insertarRelacion(aviso, noControl[i]);
    }
    return aviso;

  }*/

  @PostMapping("/enviar/mensaje")
  public AvisoEstudiante saveMessage(@RequestBody RequesAviso requesAviso) {
    System.out.println(requesAviso.getNoControl() + requesAviso.getVigencia() + requesAviso.getMensaje());
    String[] noControl = requesAviso.getNoControl().split(",");
    Estudiante estudiante;
    AvisoEstudiante aviso = avisoService.enviarMensaje(requesAviso.getMensaje(), requesAviso.getVigencia());
    for (int i = 0; i < noControl.length; i++) {
      estudiante = estudianteService.findByNoDeControl(noControl[i]);
      avisoEstudianteRelacionService.insertarRelacion(aviso,estudiante);
    }
    return aviso;
  }



 @GetMapping("/obtener/avisos/vigentes/{noDeControl}")
  public List<AvisoEstudianteDTO> buscarAvisosVigentesPorAlumno(@PathVariable String noDeControl){
    //System.out.println(noDeControl);
    return avisoService.buscarAvisosVigentesPorAlumno(noDeControl);
  }


}
