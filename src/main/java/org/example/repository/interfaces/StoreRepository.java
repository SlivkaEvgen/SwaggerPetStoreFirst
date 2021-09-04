package org.example.repository.interfaces;

import org.example.model.Order;

public interface StoreRepository {

  Integer deleteOrderById(Integer orderId);

  Order findOrderById(Integer petId);

  Integer placeAnOrderForAPet(Order order);

  Integer returnsPetInventoriesByStatus();
}
