package org.example.service;

import org.example.model.Order;
import org.example.repository.StoreRepositoryImpl;
import org.example.service.interfaces.StoreService;
import java.util.Date;

public class StoreServiceImpl implements StoreService {

  private final StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();

  @Override
  public void returnsPetInventoriesByStatus() {
    storeRepository.returnsPetInventoriesByStatus();
  }

  @Override
  public void placeAnOrderForAPet(Integer orderId, Integer petId, Integer quantity, String status) {
    Order order = new Order();
    order.setId(orderId);
    order.setPetId(petId);
    order.setComplete(true);
    order.setQuantity(quantity);
    order.setStatus(status); // placed, approved, delivered
    order.setShipDate(new Date().toString());
    storeRepository.placeAnOrderForAPet(order);
  }

  @Override
  public void findOrderById(Integer petId) {
    storeRepository.findOrderById(petId);
  }

  @Override
  public void deleteOrderById(Integer orderId) {
    storeRepository.deleteOrderById(orderId);
  }
}
