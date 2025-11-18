package com.famisanarprueba.appbackfamisanar.service;

import com.famisanarprueba.appbackfamisanar.dto.MessageDtoOut;
import com.famisanarprueba.appbackfamisanar.dto.PedidoDtoIn;
import com.famisanarprueba.appbackfamisanar.dto.VentaDtoIn;
import com.famisanarprueba.appbackfamisanar.exception.ErrorGeneralException;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;

public interface IVentaService {
  MessageDtoOut venderProducto(VentaDtoIn ventaDtoIn) throws NotFoundException, ErrorGeneralException;
}
