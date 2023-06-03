package com.platzi.market.domein.service;

import com.platzi.market.domein.Product;
import com.platzi.market.domein.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    //  ||@Component
public class ProductService {   //sirve como un negociador, un intermediario entre el controlador y la capa del repositorio
    @Autowired  //internamente inicializara un nuevo ProductRepository
    private ProductRepository productRepository;
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    /*public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }*/
    public Product save (Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);    //eliminar mi producto existente
            return true;
        }).orElse(false); //retorna falso, en caso q no haya producto que eliminar

        /*if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }else {return false;}*/
    }
}
