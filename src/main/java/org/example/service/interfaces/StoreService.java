package org.example.service.interfaces;

public interface StoreService {

  void returnsPetInventoriesByStatus();

  void placeAnOrderForAPet(Integer orderId, Integer petId, Integer quantity, String status);

  void findOrderById(Integer petId);

  void deleteOrderById(Integer orderId);
}
