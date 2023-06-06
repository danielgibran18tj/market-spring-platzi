package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrupRepository extends CrudRepository<Compra, Integer> {     //CrudRepository recibe la tabla(entity) y tipo de clave primaria

    //List<Compra> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Compra>> findByIdCliente(String idCliente);

}
