package com.backendserviciosescolares.springboot.dtoEscolares;

import java.util.Date;

public interface AvisoEstudianteDTO {
  Long getId();

  Date getVigencia();

  String getMensaje();
}
