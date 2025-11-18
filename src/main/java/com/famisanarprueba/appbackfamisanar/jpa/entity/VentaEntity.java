package com.famisanarprueba.appbackfamisanar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "venta")
public class VentaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "producto_id")
  private Integer productoId;

  @Column(name = "cantidad_vendida")
  private Integer cantidadVendida;

  @Column(name = "subtotal")
  private Long subtotal;

  @Column(name = "iva")
  private Long iva;

  @Column(name = "total")
  private Long total;
}
