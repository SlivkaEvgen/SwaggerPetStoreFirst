package org.example.controller.store;

import org.example.controller.Controller;
import org.example.service.StoreServiceImpl;
// done
public class StoreInventoryCommand implements Controller {

  @Override
  public void start() {
    StoreServiceImpl storeService = new StoreServiceImpl();
    storeService.returnsPetInventoriesByStatus();
    storeService.returnsPetInventoriesByStatus();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
