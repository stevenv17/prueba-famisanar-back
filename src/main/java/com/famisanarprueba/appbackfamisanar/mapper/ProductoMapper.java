package com.famisanarprueba.appbackfamisanar.mapper;

import com.famisanarprueba.appbackfamisanar.dto.ProductoDtoOut;
import com.famisanarprueba.appbackfamisanar.jpa.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
  @Mapping(source = "tipoProducto.iva", target = "iva")
  @Mapping(source = "tipoProducto.nombre", target = "tipo")
  ProductoDtoOut toDto(ProductoEntity productoEntity);
  List<ProductoDtoOut> toDtoList(List<ProductoEntity> productoEntityList);
}
