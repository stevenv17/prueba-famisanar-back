package com.famisanarprueba.appbackfamisanar.controller;

import com.famisanarprueba.appbackfamisanar.dto.CalculosDtoOut;
import com.famisanarprueba.appbackfamisanar.service.ICalculosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("calculos")
@RequiredArgsConstructor
public class CalculosController {

  private final ICalculosService iCalculosService;

  @GetMapping(value = "/obtener-estadisticas")
  ResponseEntity<CalculosDtoOut> getProductos() {
    return ResponseEntity.ok(iCalculosService.obtenerEstadisticas());
  }

}
