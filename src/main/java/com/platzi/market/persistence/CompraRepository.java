package com.platzi.market.persistence;

import com.platzi.market.domein.Purchase;
import com.platzi.market.domein.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.CompraCrupRepository;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrupRepository compraCrupRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrupRepository.findAll();
        return mapper.toPurchases(compras);
    }
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        /*return compraCrupRepository.findByIdCliente(clientId)
                .map(compras-> mapper.toPurchases(compras));*/  //cualquiera de las 2 formas funciona
        Optional<List<Compra>> compras = compraCrupRepository.findByIdCliente(clientId);
        return compras.map(compra -> mapper.toPurchases(compra));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase); // hacemos la conversion inversa, de purchase a compras(base de datos)
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrupRepository.save(compra));
    }
}
