package com.famisanarprueba.appbackfamisanar.jpa.repository;

import com.famisanarprueba.appbackfamisanar.jpa.entity.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoEntity, Integer> {

}
