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
  public Integer placeAnOrderForAPet(
      Integer orderId, Integer petId, Integer quantity, String status) {
    Order order = new Order();
    order.setId(Long.valueOf(orderId));
    order.setPetId(Long.valueOf(petId));
    order.setComplete(true);
    order.setQuantity(Long.valueOf(quantity));
    order.setStatus(status);
    order.setShipDate(String.valueOf(new Date().getTime()));
    return storeRepository.placeAnOrderForAPet(order);
  }

  @Override
  public Order findOrderById(Integer petId) {
    return storeRepository.findOrderById(petId);
  }

  @Override
  public Integer deleteOrderById(Integer orderId) {
    return storeRepository.deleteOrderById(orderId);
  }
}
