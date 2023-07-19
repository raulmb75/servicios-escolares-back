package com.backendserviciosescolares.springboot.service;

import com.backendserviciosescolares.springboot.dto.AlumnosInscritosDTO;
import com.backendserviciosescolares.springboot.entity.Aspirante;
import com.backendserviciosescolares.springboot.entity.Estudiante;
import com.backendserviciosescolares.springboot.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

  @Autowired
  private EstudianteRepository estudianteRepository;
  public List<Estudiante> buscarEstudiantesAsignarNoControl( Integer reticula, String periodoIngresoIt) {
    List<Estudiante> estudiantes = estudianteRepository.buscarEstudiantesAsignarNoControl(reticula, periodoIngresoIt);
    return estudiantes;
  }

  public Estudiante create(Estudiante estudiante) {
    return estudianteRepository.save(estudiante);
  }

  public Estudiante findByNoDeControl(String noDeControl) {
    return estudianteRepository.findByNoDeControl(noDeControl);
  }

  public List<Estudiante> getAllEstudiantes() {
    return estudianteRepository.findAll();
  }

  public void cambiarEstatusEstudiante(String noDeControl, String estatusAlumno ){
    Estudiante estudiante = estudianteRepository.findByNoDeControl(noDeControl);
    estudiante.setEstatusAlumno("EGR");
    estudianteRepository.save(estudiante);
    System.out.println(estatusAlumno);
  }

  /*public List<Estudiante> buscarPorCarrera(Integer reticula) {
    return estudianteRepository.findByCarera(reticula);
  }*/

  public List<Estudiante> buscarEstudiantesPorCarrera(Integer reticula){
    return estudianteRepository.buscarEstudiantesPorCarrera(reticula);
  }

  public Estudiante mostrarNipYNombre(String noDeControl){
    Estudiante data = new Estudiante();
    data.getNombreAlumno();
    data.getNip();
    return estudianteRepository.findByNoDeControl(noDeControl);
  }

  public List<Estudiante> buscarEstudiantesPorPeriodo(String periodo){
    return estudianteRepository.buscarEstudiantesPorPeriodo(periodo);
  }

  public List<AlumnosInscritosDTO> buscarAlumnosInscritos(Integer reticula, String periodo){
    return estudianteRepository.buscarEstudiantesInscritos(reticula,periodo);
  }


}
