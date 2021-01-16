package br.com.blz.testjava.controller;

import br.com.blz.testjava.controller.request.ProductRequest;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Set<Product>> findAll() {
       return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductRequest productRequest) {
        productService.create(productRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
