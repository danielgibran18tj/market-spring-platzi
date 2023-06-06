package com.platzi.market.persistence.mapper;

import com.platzi.market.domein.Purchase;
import com.platzi.market.domein.PurchaseItem;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})    //mirandolo de otra forma "ProductMapper.class" se coloca por el modelo de datos, el diagrama
public interface PurchaseMapper {
        @Mappings({
                @Mapping(source = "idCompra", target = "purchaseId"),
                @Mapping(source = "idCliente", target = "clienteId"),
                @Mapping(source = "fecha", target = "date"),
                @Mapping(source = "medioPago", target = "paymentMethod"),
                @Mapping(source = "comentario", target = "comment"),
                @Mapping(source = "productos", target = "items")
        })
        Purchase toPurchase(Compra compra);
        List<Purchase> toPurhcases(List<Compra> compras);

        @InheritInverseConfiguration    //utilice de manera inversa el mapping anterior
        @Mapping(target = "cliente", ignore = true)
        Compra toCompra(Purchase purchase);
    }
