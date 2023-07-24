package com.backendserviciosescolares.springboot.serviceEscolares;

;
import com.backendserviciosescolares.springboot.entityEscolares.Personal;
import com.backendserviciosescolares.springboot.repositoryEscolares.PersonalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService  {

  private final PersonalRepository personalRepository;

  public PersonalService(PersonalRepository personalRepository){
    this.personalRepository = personalRepository;
  }

  public List<Personal> buscarTodos(){
    return personalRepository.findAll();
  }


  public Personal guardarDatosEmpleado(Personal datosEmpleado){
    return personalRepository.save(datosEmpleado);
  }

  public void eliminarEmpleado(String rfc){
    personalRepository.deleteById(rfc);
  }

  public List<Personal> buscarPersonalPorClaveArea(String claveArea){
    return personalRepository.buscarPersonalPorClaveArea(claveArea);
  }

  public List<Personal> buscarPersonalPorLugarNacimiento(Integer lugarNacimiento){
    return personalRepository.buscarPersonalPorLugarNacimiento(lugarNacimiento);
  }

  public List<Personal> buscarPersonalPorGradoMaxEstudios(String gradoMaxEstudios){
    return personalRepository.buscarPersonalPorGradoMaxEstudios(gradoMaxEstudios);
  }
  public List<Personal> buscarPersonalPorSexo(Character sexo){
    return personalRepository.buscarPersonalPorSexo(sexo);
  }
  public List<Personal> buscarPersonalPorLocalidad(String localidad){
    return personalRepository.buscarPersonalPorLocalidad(localidad);
  }
  public List<Personal> buscarPersonalPorStatusEmpleado(String statusEmpleado){
    return personalRepository.buscarPersonalPorStatusEmpleado(statusEmpleado);
  }
}
