package com.platzi.market.domein.repository;

import com.platzi.market.domein.Product;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {    //reglas que va a tener nuestro dominio
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);    //cantidad producto escaso
    Optional<Product> getProduct(int productId);
    Product save (Product product);
    void delete(int productId);
}
