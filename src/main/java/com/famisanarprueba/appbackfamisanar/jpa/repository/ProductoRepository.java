package com.famisanarprueba.appbackfamisanar.jpa.repository;

import com.famisanarprueba.appbackfamisanar.jpa.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

  @Query(value = """
      select p from ProductoEntity p
      """)
  List<ProductoEntity> findAllProducts();

  @Query(value = """
      select p from ProductoEntity p
      where p.id = :id
      """)
  Optional<ProductoEntity> findProduct(@Param("id") Integer id);
}
