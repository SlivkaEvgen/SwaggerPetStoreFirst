package org.example.controller.store;

import org.example.controller.Controller;
import org.example.service.StoreServiceImpl;
// done
public class StoreInventoryCommand implements Controller {

  @Override
  public void start() {
      Integer id = 0;
     new StoreServiceImpl().returnsPetInventoriesByStatus(id);
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
