package com.backendserviciosescolares.springboot.service;

import com.backendserviciosescolares.springboot.dto.FichaAspiranteDTO;
import com.backendserviciosescolares.springboot.entity.Aspirante;
import com.backendserviciosescolares.springboot.repository.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AspiranteService {

  @Autowired
  private AspiranteRepository aspiranteRepository;

  public List<Aspirante> getAllAspirantes() {
    return aspiranteRepository.findAll();
  }

  public Aspirante obtenerAspirantePorCurp(String curp){
    return aspiranteRepository.findByCurp(curp);
  }

  public List<FichaAspiranteDTO> buscarDatosFichaAspirante(String curp){
    return aspiranteRepository.buscarDatosFichaAspirante(curp);
  }
}
