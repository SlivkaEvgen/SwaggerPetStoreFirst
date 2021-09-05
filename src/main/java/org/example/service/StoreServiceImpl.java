package org.example.service;

import org.example.model.Order;
import org.example.repository.StoreRepositoryImpl;
import org.example.service.interfaces.StoreService;
import java.util.Date;

public class StoreServiceImpl implements StoreService<Order,Integer> {

  private final StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();

  @Override
  public void returnsPetInventoriesByStatus(Integer id) {
      storeRepository.get(id);
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
    return storeRepository.create(order);
  }

  @Override
  public Order findById(Integer petId) {
    return storeRepository.findById(petId);
  }

  @Override
  public Integer delete(Integer orderId) {
    return storeRepository.delete(orderId);
  }
}
