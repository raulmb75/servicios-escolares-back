package com.backendserviciosescolares.springboot.entityEscolares;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "aviso_estudiante_intermedio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvisoEstudiantePK {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //@Column(name = "id_estudiante")
  @JoinColumn(name = "id_estudiante", referencedColumnName = "no_de_control")
  @ManyToOne
  private Estudiante idEstudiante;

  //@Column(name = "id_aviso")
  @JoinColumn(name = "id_aviso", referencedColumnName = "id")
  @ManyToOne
  private AvisoEstudiante idAviso;

}

