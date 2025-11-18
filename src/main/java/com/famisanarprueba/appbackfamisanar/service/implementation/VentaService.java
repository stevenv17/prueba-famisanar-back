package com.famisanarprueba.appbackfamisanar.service.implementation;

import com.famisanarprueba.appbackfamisanar.dto.MessageDtoOut;
import com.famisanarprueba.appbackfamisanar.dto.VentaDtoIn;
import com.famisanarprueba.appbackfamisanar.exception.ErrorGeneralException;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;
import com.famisanarprueba.appbackfamisanar.jpa.entity.ProductoEntity;
import com.famisanarprueba.appbackfamisanar.jpa.entity.VentaEntity;
import com.famisanarprueba.appbackfamisanar.jpa.repository.ProductoRepository;
import com.famisanarprueba.appbackfamisanar.jpa.repository.VentaRepository;
import com.famisanarprueba.appbackfamisanar.service.IVentaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utilities.Constants;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VentaService implements IVentaService {

  private final VentaRepository ventaRepository;
  private final ProductoRepository productoRepository;

  @Override
  @Transactional
  public MessageDtoOut venderProducto(VentaDtoIn ventaDtoIn) throws NotFoundException, ErrorGeneralException {

    Optional<ProductoEntity> productEntityOptional = productoRepository.findProduct(ventaDtoIn.getProductoId());
    if(productEntityOptional.isEmpty()) {
      throw new NotFoundException("Product not found");
    }
    ProductoEntity productoEntity = productEntityOptional.get();

    if(productoEntity.getCantidad() < ventaDtoIn.getCantidad()) {
      throw new ErrorGeneralException("La cantidad supera las unidades disponibles");
    }
    int nuevaCantidad = productoEntity.getCantidad() - ventaDtoIn.getCantidad();
    productoEntity.setCantidad(nuevaCantidad);
    productoRepository.save(productoEntity);

    VentaEntity ventaEntity = new VentaEntity();
    ventaEntity.setProductoId(ventaDtoIn.getProductoId());
    ventaEntity.setCantidadVendida(ventaDtoIn.getCantidad());
    long iva = productoEntity.getTipoProducto().getIva();
    ventaEntity.setIva(iva);
    long subtotal = ventaDtoIn.getCantidad() * productoEntity.getPrecioBase();
    long total = (long) (subtotal * (iva / 100.0)) + subtotal;
    ventaEntity.setSubtotal(subtotal);
    ventaEntity.setTotal(total);
    ventaRepository.save(ventaEntity);


    MessageDtoOut messageDtoOut = new MessageDtoOut();
    messageDtoOut.setResult(Constants.OK);
    messageDtoOut.setMessage("Venta realizada correctamente");
    return messageDtoOut;
  }
}
