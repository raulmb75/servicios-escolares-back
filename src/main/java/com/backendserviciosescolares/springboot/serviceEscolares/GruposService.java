package com.backendserviciosescolares.springboot.serviceEscolares;


import com.backendserviciosescolares.springboot.entityEscolares.Grupos;
import com.backendserviciosescolares.springboot.repositoryEscolares.GruposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GruposService {

  @Autowired
  private GruposRepository gruposRepository;

  public List<Grupos> buscarGruposPorCarrera(Integer reticula){
    return gruposRepository.buscarGruposPorCarrera(reticula);
  }

  public List<Grupos> buscarGruposPorCarreraYperiodo(Integer reticula, String periodo){
    return gruposRepository.buscarGruposPorCarreraYperiodo(reticula,periodo);
  }
}
