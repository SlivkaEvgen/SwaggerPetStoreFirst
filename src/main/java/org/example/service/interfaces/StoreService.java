package org.example.service.interfaces;

import org.example.model.Order;

public interface StoreService<T, ID> extends Service<T, ID> {

  void returnsPetInventoriesByStatus();

  Order placeAnOrderForAPet(Long orderId, Long petId, Integer quantity, String status);

  Order findById(Long petId);

  Long delete(Long orderId);
}
