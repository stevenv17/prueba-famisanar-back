package com.famisanarprueba.appbackfamisanar.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PedidoDtoIn {
  @NotNull
  @Positive
  private Integer productoId;

  @NotNull
  @Min(1)
  private Integer cantidad;
}
