package com.famisanarprueba.appbackfamisanar.service.implementation;

import com.famisanarprueba.appbackfamisanar.dto.CalculosDtoOut;
import com.famisanarprueba.appbackfamisanar.jpa.repository.ProductoRepository;
import com.famisanarprueba.appbackfamisanar.service.ICalculosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CalculosService implements ICalculosService {

  private final ProductoRepository productoRepository;

  @Override
  public CalculosDtoOut obtenerEstadisticas() {

    List<Object[]> masVendido = productoRepository.obtenerProductoMasVendido();
    List<Object[]> menosVendido = productoRepository.obtenerProductoMenosVendido();
    String masVendidoProducto = (!masVendido.isEmpty() && masVendido.get(0)[0] != null) ? masVendido.get(0)[0].toString() : null;
    String menosVendidoProducto = (!menosVendido.isEmpty() && menosVendido.get(0)[0] != null) ? menosVendido.get(0)[0].toString() : null;


    CalculosDtoOut calculosDtoOut = new CalculosDtoOut();
    calculosDtoOut.setIngresos(0L);
    calculosDtoOut.setPromedio(0L);
    calculosDtoOut.setProductoMasVendido(masVendidoProducto);
    calculosDtoOut.setProductoMenosVendido(menosVendidoProducto);


    return calculosDtoOut;
  }
}
