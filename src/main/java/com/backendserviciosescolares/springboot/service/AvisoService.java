package com.backendserviciosescolares.springboot.service;

import com.backendserviciosescolares.springboot.dto.AvisoEstudianteDTO;
import com.backendserviciosescolares.springboot.entity.AvisoEstudiante;
import com.backendserviciosescolares.springboot.repository.AvisoEstudianteRelacionRepository;
import com.backendserviciosescolares.springboot.repository.AvisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AvisoService {

  @Autowired
  private AvisoEstudianteRelacionRepository avisoEstudianteRelacionRepository;


  @Autowired
  private AvisoEstudianteRelacionService avisoEstudianteRelacionService;
  @Autowired
  private AvisoRepository avisoRepository;

  public AvisoService(AvisoRepository avisoRepository) {
    this.avisoRepository = avisoRepository;
  }

  public AvisoEstudiante enviarMensaje(String mensaje, Date vigencia) {
    AvisoEstudiante nuevoMensaje = new AvisoEstudiante();
    nuevoMensaje.setMensaje(mensaje);
    nuevoMensaje.setVigencia(vigencia);

    return avisoRepository.save(nuevoMensaje);

  }

  public List<AvisoEstudianteDTO> buscarAvisosVigentesPorAlumno(String noDeControl){
    return avisoRepository.buscarAvisosVigentesPorAlumno(noDeControl);
  }
}
