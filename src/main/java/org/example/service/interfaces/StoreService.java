package org.example.service.interfaces;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.example.model.Order;

public interface StoreService {

  void returnsPetInventoriesByStatus();

  Integer placeAnOrderForAPet(Integer orderId, Integer petId, Integer quantity, String status);

  Order findOrderById(Integer petId);

  Integer deleteOrderById(Integer orderId);
}
