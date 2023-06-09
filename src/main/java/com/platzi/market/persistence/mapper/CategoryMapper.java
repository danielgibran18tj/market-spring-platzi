package com.platzi.market.persistence.mapper;

import com.platzi.market.domein.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")  //importante senialar el componente de tipo spring
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),      //fuente / destino
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration    //anotacion para mapear inverso de mi Mappings
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
