package com.famisanarprueba.appbackfamisanar.service.implementation;

import com.famisanarprueba.appbackfamisanar.dto.ProductoDtoOut;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;

import com.famisanarprueba.appbackfamisanar.jpa.entity.ProductoEntity;
import com.famisanarprueba.appbackfamisanar.jpa.repository.ProductoRepository;
import com.famisanarprueba.appbackfamisanar.mapper.ProductoMapper;
import com.famisanarprueba.appbackfamisanar.service.IProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

  private final ProductoRepository productoRepository;
  private final ProductoMapper productoMapper;


  @Override
  public List<ProductoDtoOut> getProductoList() {
    List<ProductoEntity> productEntityList = productoRepository.findAllProducts();
    return productoMapper.toDtoList(productEntityList);
  }

  @Override
  public ProductoDtoOut getProducto(Integer id) throws NotFoundException {
    Optional<ProductoEntity> productEntityOptional = productoRepository.findProduct(id);
    if(productEntityOptional.isEmpty()) {
      throw new NotFoundException("Product not found");
    }
    return productoMapper.toDto(productEntityOptional.get());
  }

}
