package org.example.service.interfaces;

import org.example.model.Order;

public interface StoreService<T,ID> extends Service<T, ID> {

  void returnsPetInventoriesByStatus(ID id);

  Integer placeAnOrderForAPet(Integer orderId, Integer petId, Integer quantity, String status);

  Order findById(Integer petId);

  Integer delete(Integer orderId);
}
