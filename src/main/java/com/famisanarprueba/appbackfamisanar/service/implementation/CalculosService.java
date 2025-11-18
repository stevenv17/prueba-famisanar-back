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
    List<Object[]> ingresoTotalVentas = productoRepository.obtenerIngresoTotalVentas();
    List<Object[]> totalProductosVendidos = productoRepository.obtenerCantidadVendidos();

    String masVendidoProducto = objectToString(masVendido);
    String menosVendidoProducto = objectToString(menosVendido);
    Long ingresoTotal = objectToLong(ingresoTotalVentas);
    Long totalVendidos = objectToLong(totalProductosVendidos);
    Long promedio = ingresoTotal/totalVendidos;

    CalculosDtoOut calculosDtoOut = new CalculosDtoOut();
    calculosDtoOut.setIngresos(ingresoTotal);
    calculosDtoOut.setPromedio(promedio);
    calculosDtoOut.setProductoMasVendido(masVendidoProducto);
    calculosDtoOut.setProductoMenosVendido(menosVendidoProducto);


    return calculosDtoOut;
  }

  private String objectToString(List<Object[]> object) {
    return (!object.isEmpty() && object.get(0)[0] != null) ? object.get(0)[0].toString() : null;
  }

  private Long objectToLong(List<Object[]> object) {
    return (!object.isEmpty() && object.get(0)[0] != null) ? ((Number) object.get(0)[0]).longValue() : 0L;
  }
}
