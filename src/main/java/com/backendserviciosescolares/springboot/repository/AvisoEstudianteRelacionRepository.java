package com.backendserviciosescolares.springboot.repository;

import com.backendserviciosescolares.springboot.entity.AvisoEstudiantePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisoEstudianteRelacionRepository extends JpaRepository <AvisoEstudiantePK, Long> {


}
