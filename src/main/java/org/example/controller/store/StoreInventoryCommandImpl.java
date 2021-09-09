package org.example.controller.store;

import org.example.controller.Controller;
import org.example.service.StoreServiceImpl;

public class StoreInventoryCommandImpl implements Controller {

  private final StoreServiceImpl storeService = StoreServiceImpl.getStoreService();
  private static StoreInventoryCommandImpl storeInventoryCommand;

  public static StoreInventoryCommandImpl getStoreInventoryCommand() {
    if (storeInventoryCommand == null) {
      storeInventoryCommand = new StoreInventoryCommandImpl();
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
