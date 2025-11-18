package com.famisanarprueba.appbackfamisanar.service.implementation;

import com.famisanarprueba.appbackfamisanar.dto.MessageDtoOut;
import com.famisanarprueba.appbackfamisanar.dto.PedidoDtoIn;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;
import com.famisanarprueba.appbackfamisanar.jpa.entity.PedidoEntity;
import com.famisanarprueba.appbackfamisanar.jpa.entity.ProductoEntity;
import com.famisanarprueba.appbackfamisanar.jpa.repository.PedidoRepository;
import com.famisanarprueba.appbackfamisanar.jpa.repository.ProductoRepository;
import com.famisanarprueba.appbackfamisanar.service.IPedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utilities.Constants;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoService implements IPedidoService {

  private final PedidoRepository pedidoRepository;
  private final ProductoRepository productoRepository;

  @Override
  @Transactional
  public MessageDtoOut hacerPedido(PedidoDtoIn pedidoDtoIn) throws NotFoundException {
    Optional<ProductoEntity> productEntityOptional = productoRepository.findProduct(pedidoDtoIn.getProductoId());
    if(productEntityOptional.isEmpty()) {
      throw new NotFoundException("No se encontró el producto");
    }

    ProductoEntity productoEntity = productEntityOptional.get();
    int cantidad = productoEntity.getCantidad() + pedidoDtoIn.getCantidad();
    productoEntity.setCantidad(cantidad);
    productoRepository.save(productoEntity);

    PedidoEntity pedidoEntity = new PedidoEntity();
    pedidoEntity.setProductoId(pedidoDtoIn.getProductoId());
    pedidoEntity.setCantidad(pedidoDtoIn.getCantidad());
    pedidoRepository.save(pedidoEntity);

    MessageDtoOut messageDtoOut = new MessageDtoOut();
    messageDtoOut.setResult(Constants.OK);
    messageDtoOut.setMessage("Pedido realizado correctamente");
    return messageDtoOut;
  }
}
