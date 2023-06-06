package com.platzi.market.domein.service;

import com.platzi.market.domein.Product;
import com.platzi.market.domein.Purchase;
import com.platzi.market.domein.repository.ProductRepository;
import com.platzi.market.domein.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PurchaseService {
    @Autowired  //internamente inicializara un nuevo PurchaseRepository
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {   //lista de compra realizada por X cliente especifico
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
