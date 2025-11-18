package com.famisanarprueba.appbackfamisanar.controller;

import com.famisanarprueba.appbackfamisanar.dto.MessageDtoOut;
import com.famisanarprueba.appbackfamisanar.dto.PedidoDtoIn;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;
import com.famisanarprueba.appbackfamisanar.service.IPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
public class PedidoController {
  private final IPedidoService iPedidoService;

  @PostMapping(value = "nuevo-pedido")
  ResponseEntity<MessageDtoOut> hacerPedido(@RequestBody @Valid PedidoDtoIn pedidoDtoIn) throws NotFoundException {
    return ResponseEntity.ok(iPedidoService.hacerPedido(pedidoDtoIn));
  }
}
