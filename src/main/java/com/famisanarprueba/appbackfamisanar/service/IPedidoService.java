package com.famisanarprueba.appbackfamisanar.service;

import com.famisanarprueba.appbackfamisanar.dto.MessageDtoOut;
import com.famisanarprueba.appbackfamisanar.dto.PedidoDtoIn;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;

public interface IPedidoService {
  MessageDtoOut hacerPedido(PedidoDtoIn pedidoDtoIn) throws NotFoundException;
}
