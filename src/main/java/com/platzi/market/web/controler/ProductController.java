package com.platzi.market.web.controler;

import com.platzi.market.domein.Product;
import com.platzi.market.domein.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //indica que esta clase sera controlador de una APIREST
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;//inyeccion de servicio

    @GetMapping("/all")     //http://localhost:8090/platzi-market/api/products/all
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK); //respondio de manera adecuada cuando fue llamada
    }

    @GetMapping("/{id}")    //http://localhost:8090/platzi-market/api/products/10
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){   //con ResponseEntity ya no es necesario Optional<Product>
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));    //en caso que no exista un producto, no respondera NULL sino NOT_FOUND
    }

    @GetMapping("/category/{categoryId}")   //http://localhost:8090/platzi-market/api/products/category/4
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        //return productService.getByCategory(categoryId);
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save (@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){  //se reemplaza el BOOLEAN
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
