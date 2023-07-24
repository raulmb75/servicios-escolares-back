package com.backendserviciosescolares.springboot.entityEscolares;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tipo_materia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoMateria {

  @Id
  @Basic(optional = false)
  @Column(name = "tipo_materia")
  private Integer tipoMateria;
  @Column(name = "nombre_tipo", length = 50)
  private String nombreTipo;
}
