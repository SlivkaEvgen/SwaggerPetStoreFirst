package org.example.controller.store;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.service.StoreServiceImpl;

import java.util.Scanner;

// done
public class StoreInventoryCommandImpl implements Controller {
    private final Scanner scanner = ScannerConsole.getInstance();
  @Override
  public void start() {
    int r = 0;
     new StoreServiceImpl().returnsPetInventoriesByStatus(r);
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
