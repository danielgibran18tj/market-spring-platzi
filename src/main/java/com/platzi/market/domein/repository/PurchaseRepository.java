package com.platzi.market.domein.repository;

import com.platzi.market.domein.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();    //recuperar lista de compras que han ocurrido dentro del supermercado
    Optional<List<Purchase>> getByClient(String clientId);    //lista de compra realizada por X cliente especifico
    Purchase save(Purchase purchase);   //guardar o registrar compra

}
