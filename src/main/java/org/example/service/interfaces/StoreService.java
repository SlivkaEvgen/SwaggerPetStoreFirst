package org.example.service.interfaces;

import org.example.model.Order;

public interface StoreService extends Service<Order, Long> {

  void returnsPetInventoriesByStatus();

  Order placeAnOrderForAPet(Long orderId, Long petId, Integer quantity, String status);
}
