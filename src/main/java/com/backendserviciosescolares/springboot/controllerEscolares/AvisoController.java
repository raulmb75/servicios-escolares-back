package com.backendserviciosescolares.springboot.controllerEscolares;

import com.backendserviciosescolares.springboot.dtoEscolares.AvisoEstudianteDTO;
import com.backendserviciosescolares.springboot.dtoEscolares.RequesAviso;
import com.backendserviciosescolares.springboot.entityEscolares.AvisoEstudiante;
import com.backendserviciosescolares.springboot.entityEscolares.Estudiante;
import com.backendserviciosescolares.springboot.repositoryEscolares.AvisoEstudianteRelacionRepository;
import com.backendserviciosescolares.springboot.repositoryEscolares.AvisoRepository;
import com.backendserviciosescolares.springboot.serviceEscolares.AvisoEstudianteRelacionService;
import com.backendserviciosescolares.springboot.serviceEscolares.AvisoService;
import com.backendserviciosescolares.springboot.serviceEscolares.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@Controller
@RequestMapping(value="/escolares/avisos")
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
