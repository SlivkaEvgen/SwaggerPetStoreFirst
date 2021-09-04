package org.example.service.interfaces;

import org.example.model.Order;

public interface StoreService {

  void returnsPetInventoriesByStatus();

  Integer placeAnOrderForAPet(Integer orderId, Integer petId, Integer quantity, String status);

  Order findOrderById(Integer petId);

  Integer deleteOrderById(Integer orderId);
}
