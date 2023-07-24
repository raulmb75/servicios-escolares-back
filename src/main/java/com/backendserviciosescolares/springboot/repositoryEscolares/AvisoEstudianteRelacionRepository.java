package com.backendserviciosescolares.springboot.repositoryEscolares;

import com.backendserviciosescolares.springboot.entityEscolares.AvisoEstudiantePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisoEstudianteRelacionRepository extends JpaRepository <AvisoEstudiantePK, Long> {


}
