package com.backendserviciosescolares.springboot.repositoryEscolares;

import com.backendserviciosescolares.springboot.entityEscolares.NivelEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelEscolarRepository extends JpaRepository <NivelEscolar, Character> {
}
