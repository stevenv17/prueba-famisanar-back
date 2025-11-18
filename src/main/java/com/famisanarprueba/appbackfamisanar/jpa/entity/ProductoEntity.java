package com.famisanarprueba.appbackfamisanar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class ProductoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "tipo_id")
  private Integer tipoId;

  @ManyToOne
  @JoinColumn(name = "tipo_id", referencedColumnName = "id", insertable = false, updatable = false)
  private TipoProductoEntity tipoProducto;

  @Column(name = "cantidad")
  private Integer cantidad;

  @Column(name = "cantidad_min_pedido")
  private Integer cantidadMinPedido;

  @Column(name = "precio_base")
  private Long precioBase;


}
