package com.famisanarprueba.appbackfamisanar.controller;

import com.famisanarprueba.appbackfamisanar.dto.ProductoDtoOut;
import com.famisanarprueba.appbackfamisanar.exception.NotFoundException;
import com.famisanarprueba.appbackfamisanar.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto")
@RequiredArgsConstructor
public class ProductoController {

  private final IProductoService iProductoService;


  @GetMapping(value = "/lista")
  ResponseEntity<List<ProductoDtoOut>> getProductos() throws NotFoundException {
    return ResponseEntity.ok(iProductoService.getProductoList());
  }

  @GetMapping(value = "/{id}")
  ResponseEntity<ProductoDtoOut> getProducto(@PathVariable("id") Integer id) throws NotFoundException {
    return ResponseEntity.ok(iProductoService.getProducto(id));
  }

}
