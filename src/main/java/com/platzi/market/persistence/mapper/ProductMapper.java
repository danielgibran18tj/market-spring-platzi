package com.platzi.market.persistence.mapper;

import com.platzi.market.domein.Category;
import com.platzi.market.domein.Product;
import com.platzi.market.persistence.entity.Categoria;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})  //importante senialar el componente de tipo spring
//mirandolo de otra forma "CategoryMapper.class" se coloca por el modelo de datos, el diagrama
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);


    @InheritInverseConfiguration    //anotacion para mapear inverso de mi Mappings
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
