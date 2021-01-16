package br.com.blz.testjava.service.impl;

import br.com.blz.testjava.controller.request.InventoryRequest;
import br.com.blz.testjava.controller.request.ProductRequest;
import br.com.blz.testjava.entity.Inventory;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.repository.ProductRepository;
import br.com.blz.testjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<Product> findAll() {

        Set<Product> products =  productRepository.findAll();

        products.forEach(product -> {
                if(product.getInventory().getQuantity() > 0) {
                    product.setIsMarketable(true);
                }
            });

        return products;
    }

    @Override
    public void create(ProductRequest productRequest) {

        InventoryRequest inventoryRequest = productRequest.getInventory();
        Inventory inventory = new Inventory(inventoryRequest.getWarehouses());

        Product product = new Product(
            productRequest.getSku(),
            productRequest.getName(),
            inventory
        );

        productRepository.save(product);
    }
}
