package com.famisanarprueba.appbackfamisanar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoDtoOut {
  private Integer id;
  private String nombre;
  private String tipo;
  private Integer cantidad;
  private Integer cantidadMinPedido;
  private Long precioBase;
  private Long iva;
}
