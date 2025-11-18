package com.famisanarprueba.appbackfamisanar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_producto")
public class TipoProductoEntity {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "iva")
  private Long iva;
}
