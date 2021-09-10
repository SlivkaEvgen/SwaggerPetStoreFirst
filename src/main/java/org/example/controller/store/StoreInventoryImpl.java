package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.controller.interfaces.Controller;
import org.example.service.StoreServiceImpl;

@NoArgsConstructor
public class StoreInventoryImpl implements Controller {

  private final StoreServiceImpl storeService = StoreServiceImpl.getStoreService();
  private static StoreInventoryImpl storeInventoryCommand;

  public static StoreInventoryImpl getStoreInventoryCommand() {
    if (storeInventoryCommand == null) {
      storeInventoryCommand = new StoreInventoryImpl();
    }
    return storeInventoryCommand;
  }

  @Override
  public void start() {
    storeService.returnsPetInventoriesByStatus();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
