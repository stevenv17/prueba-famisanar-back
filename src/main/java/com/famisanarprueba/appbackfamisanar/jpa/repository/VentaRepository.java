package com.famisanarprueba.appbackfamisanar.jpa.repository;

import com.famisanarprueba.appbackfamisanar.jpa.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {

}
