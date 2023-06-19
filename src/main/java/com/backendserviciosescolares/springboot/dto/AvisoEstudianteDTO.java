package com.backendserviciosescolares.springboot.dto;

import javax.persistence.Column;
import java.util.Date;

public interface AvisoEstudianteDTO {
  Long getId();

  Date getVigencia();

  String getMensaje();
}
