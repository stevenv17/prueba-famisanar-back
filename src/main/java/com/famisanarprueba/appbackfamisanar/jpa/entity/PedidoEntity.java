package com.famisanarprueba.appbackfamisanar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "producto_id")
  private Integer productoId;

  @Column(name = "cantidad")
  private Integer cantidad;


}
