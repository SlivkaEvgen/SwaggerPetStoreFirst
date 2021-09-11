package org.example.repository.interfaces;

import org.example.model.Order;

public interface StoreRepository extends Repository<Order, Long> {

  String getInventory();
}
