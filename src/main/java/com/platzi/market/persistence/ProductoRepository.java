package com.platzi.market.persistence;

import com.platzi.market.domein.Product;
import com.platzi.market.domein.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //indicamos que esta clase esta interactuando con la base de datos
public class ProductoRepository implements ProductRepository {
    @Autowired  //este objeto creara instancias por medio de Spring, inyectara las dependencias necesarias para su funcionamiento
    private ProductoCrudRepository productoCrudRepository;
    @Autowired  //esta debe inyectarse en clases relacionadas con Spring
    private ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    @Override
    public Product save(Product product) {  //funciona al reves, ingresando un producto a la base de datos
        Producto producto = mapper.toProducto(product); // hacemos la conversion inversa, de product a producto(base de datos)
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
