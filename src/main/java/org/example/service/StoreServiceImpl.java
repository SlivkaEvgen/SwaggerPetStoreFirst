package org.example.service;

import lombok.NoArgsConstructor;
import org.example.model.Order;
import org.example.repository.StoreRepositoryImpl;
import org.example.service.interfaces.StoreService;

import java.util.Date;

@NoArgsConstructor
public class StoreServiceImpl implements StoreService<Order, Long> {

  private final StoreRepositoryImpl storeRepository = StoreRepositoryImpl.getStoreRepository();
  private static StoreServiceImpl storeService;

  public static StoreServiceImpl getStoreService() {
    if (storeService == null) {
      storeService = new StoreServiceImpl();
    }
    return storeService;
  }

  @Override
  public void returnsPetInventoriesByStatus() {
    storeRepository.getInventory();
  }

  @Override
  public Order placeAnOrderForAPet(Long orderId, Long petId, Integer quantity, String status) {
    Order order = new Order();
    order.setId(orderId);
    order.setPetId(petId);
    order.setComplete(true);
    order.setQuantity(quantity);
    order.setStatus(status);
    order.setShipDate(String.valueOf(new Date().getTime()));
    return storeRepository.create(order);
  }

  @Override
  public Order findById(Long petId) {
    return storeRepository.getById(petId);
  }

  @Override
  public Long delete(Long orderId) {
    return storeRepository.delete(orderId);
  }
}
