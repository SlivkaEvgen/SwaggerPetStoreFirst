package org.example.repository.interfaces;

import org.example.model.Order;

public interface StoreRepository {

  void deleteOrderById(Integer orderId);

  void findOrderById(Integer petId);

  void placeAnOrderForAPet(Order order);

  void returnsPetInventoriesByStatus();
}
