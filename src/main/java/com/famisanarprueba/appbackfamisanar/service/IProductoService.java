package com.famisanarprueba.appbackfamisanar.service;


import com.famisanarprueba.appbackfamisanar.dto.ProductoDtoOut;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;

import java.util.List;

public interface IProductoService {
  List<ProductoDtoOut> getProductoList();
  ProductoDtoOut getProducto(Integer id) throws NotFoundException;
}
