package org.example.controller.store;

import org.example.controller.Controller;
import org.example.service.StoreServiceImpl;
// ok
public class StoreInventoryCommandImpl implements Controller {

  @Override
  public void start() {
    new StoreServiceImpl().returnsPetInventoriesByStatus(0);
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
