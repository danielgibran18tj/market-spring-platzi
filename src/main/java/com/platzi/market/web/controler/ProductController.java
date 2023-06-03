package com.platzi.market.web.controler;

import com.platzi.market.domein.Product;
import com.platzi.market.domein.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //indica que esta clase sera controlador de una APIREST
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;//inyeccion de servicio

    @GetMapping("/all")     //http://localhost:8090/platzi-market/api/products/all
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")    //http://localhost:8090/platzi-market/api/products/10
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")   //http://localhost:8090/platzi-market/api/products/category/4
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save (@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }

}
