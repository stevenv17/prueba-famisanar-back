package com.famisanarprueba.appbackfamisanar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CalculosDtoOut {

  private Long ingresos;
  private String productoMasVendido;
  private String productoMenosVendido;
  private Long promedio;
}
