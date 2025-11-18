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


  @Query(value = """
      SELECT p.nombre, v.producto_id, SUM(v.cantidad_vendida) AS total_vendida
      FROM venta v
      JOIN producto p ON p.id = v.producto_id
      GROUP BY v.producto_id, p.nombre
      ORDER BY total_vendida DESC
      LIMIT 1
      """, nativeQuery = true)
  List<Object[]> obtenerProductoMasVendido();

  @Query(value = """
      SELECT p.nombre, v.producto_id, SUM(v.cantidad_vendida) AS total_vendida
      FROM venta v
      JOIN producto p ON p.id = v.producto_id
      GROUP BY v.producto_id, p.nombre
      ORDER BY total_vendida ASC
      LIMIT 1
      """, nativeQuery = true)
  List<Object[]> obtenerProductoMenosVendido();


  @Query(value = """
      SELECT SUM(total)
      FROM venta v
      """, nativeQuery = true)
  List<Object[]> obtenerIngresoTotalVentas();


}
