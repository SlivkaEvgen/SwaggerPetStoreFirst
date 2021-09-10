package org.example.service.interfaces;

public interface StoreService<T, ID> extends Service<T, ID> {

  void returnsPetInventoriesByStatus();

  T placeAnOrderForAPet(ID orderId, ID petId, Integer quantity, String status);

  T findById(ID petId);

  ID delete(ID orderId);
}
