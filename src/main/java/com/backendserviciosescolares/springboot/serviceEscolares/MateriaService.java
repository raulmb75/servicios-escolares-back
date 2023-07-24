package com.backendserviciosescolares.springboot.serviceEscolares;

import com.backendserviciosescolares.springboot.entityEscolares.Materia;
import com.backendserviciosescolares.springboot.repositoryEscolares.MateriaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MateriaService {

  private final MateriaRepository materiaRepository;

  public MateriaService(MateriaRepository materiaRepository) {
    this.materiaRepository = materiaRepository;
  }

  public List<Materia> buscarTodasMaterias(){
    return materiaRepository.findAll();
  }

  public Materia buscarMateriaPorClave(String claveMateria){
    Materia materia =  materiaRepository.findById(claveMateria)
      .orElseThrow(()->
        new EntityNotFoundException("Materia con clave " + claveMateria + " no registrada"));

    return materia;
  }

  public Materia registrarMateria(Materia materia){
    return materiaRepository.save(materia);
  }

  public Materia actualizarDatosMateria(String claveMateria, Materia materia){
    Materia materiaRegistrada = materiaRepository.findById(claveMateria).orElse(null);

    if(materiaRegistrada != null) {
      return materiaRepository.save(materia);
    }

    throw new EntityNotFoundException(String.format("Materia con clave %s no registrada", claveMateria));
  }

  public void eliminarMateria(String claveMateria){
    materiaRepository.deleteById(claveMateria);
  }

  public List<Materia> buscarMateriaPorNivelEscolar(Character nivelEscolar){
    return materiaRepository.buscarMateriaPorNivelEscolar(nivelEscolar);
  }

  public List<Materia> buscarMateriaPorDepartamento(String claveArea){
    return materiaRepository.buscarMateriaPorDepartamento(claveArea);
  }

  public List<Materia> buscarMateriaPorTipo(Integer tipoMateria){
    return materiaRepository.buscarMateriaPorTipo(tipoMateria);
  }
}
