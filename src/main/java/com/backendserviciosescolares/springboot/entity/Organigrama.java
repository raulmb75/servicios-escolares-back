package com.backendserviciosescolares.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "organigrama")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate
//@DynamicInsert
public class Organigrama {
  @Id
  @Basic(optional = false)
  @Column(name = "clave_area")
  private String claveArea;
  @Basic(optional = false)
  @Column(name = "descripcion_area")
  private String descripcionArea;
  @Basic(optional = false)
  @Column(name = "nivel")
  private Integer nivel;
  @Basic(optional = false)
  @Column(name = "tipo_area")
  private Character tipoArea;
  @Column(name = "p_sustantivos")
  private String pSustantivos;
  @Column(name = "pro_sus")
  private String proSus;
  @Column(name = "p_sus")
  private String pSus;
  @Column(name = "p_s")
  private String pS;
  @Column(name = "extencion")
  private String extencion;
  @Column(name = "siglas")
  private String siglas;
  @Column(name = "area_depende")
  private String areaDepende;
}
