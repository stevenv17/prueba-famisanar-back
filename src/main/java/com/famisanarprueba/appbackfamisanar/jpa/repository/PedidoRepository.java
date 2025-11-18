package com.famisanarprueba.appbackfamisanar.jpa.repository;

import com.famisanarprueba.appbackfamisanar.jpa.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

}
