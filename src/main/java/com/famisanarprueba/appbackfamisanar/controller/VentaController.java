package com.famisanarprueba.appbackfamisanar.controller;

import com.famisanarprueba.appbackfamisanar.dto.MessageDtoOut;
import com.famisanarprueba.appbackfamisanar.dto.VentaDtoIn;
import com.famisanarprueba.appbackfamisanar.exception.ErrorGeneralException;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;
import com.famisanarprueba.appbackfamisanar.service.IVentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("venta")
@RequiredArgsConstructor
public class VentaController {
  private final IVentaService iVentaService;

  @PostMapping(value = "vender-producto")
  ResponseEntity<MessageDtoOut> venderProducto(@RequestBody @Valid VentaDtoIn ventaDtoIn) throws NotFoundException, ErrorGeneralException {
    return ResponseEntity.ok(iVentaService.venderProducto(ventaDtoIn));
  }
}
