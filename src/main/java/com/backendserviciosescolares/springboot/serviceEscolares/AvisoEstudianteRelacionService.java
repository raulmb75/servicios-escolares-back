package com.backendserviciosescolares.springboot.serviceEscolares;


import com.backendserviciosescolares.springboot.entityEscolares.AvisoEstudiante;
import com.backendserviciosescolares.springboot.entityEscolares.AvisoEstudiantePK;
import com.backendserviciosescolares.springboot.entityEscolares.Estudiante;
import com.backendserviciosescolares.springboot.repositoryEscolares.AvisoEstudianteRelacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisoEstudianteRelacionService {

  @Autowired
  private AvisoEstudianteRelacionRepository avisoEstudianteRelacionRepository;

 /* public AvisoEstudiantePK insertarRelacion(Long idAviso, String idEstudiante){
    AvisoEstudiantePK guardarDatos = new AvisoEstudiantePK();
    guardarDatos.setIdAviso(idAviso);
    guardarDatos.setIdEstudiante(idEstudiante);

    return avisoEstudianteRelacionRepository.save(guardarDatos);
  }*/
  public AvisoEstudiantePK insertarRelacion(AvisoEstudiante idAviso, Estudiante idEstudiante){
    AvisoEstudiantePK guardarDatos = new AvisoEstudiantePK();
    guardarDatos.setIdAviso(idAviso);
    guardarDatos.setIdEstudiante(idEstudiante);

    return avisoEstudianteRelacionRepository.save(guardarDatos);
  }




}
