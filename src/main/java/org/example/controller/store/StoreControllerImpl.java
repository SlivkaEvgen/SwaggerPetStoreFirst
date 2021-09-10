package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.ControllerImpl;
import org.example.controller.interfaces.StoreController;

import java.util.Scanner;

@NoArgsConstructor
public class StoreControllerImpl implements StoreController {

  private final Scanner scanner = ScannerConsole.getInstance();
  private static StoreControllerImpl storeController;

  public static StoreControllerImpl getStoreController() {
    if (storeController == null) {
      storeController = new StoreControllerImpl();
    }
    return storeController;
  }

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 Inventory\n \uD83D\uDC49 CreateOrder\n \uD83D\uDC49 FindOrder \n \uD83D\uDC49 DeleteOrder \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("Inventory")) {
      getInventory();
      start();
    }
    if (next.equalsIgnoreCase("CreateOrder")) {
      create();
      start();
    }
    if (next.equalsIgnoreCase("FindOrder")) {
      get();
      start();
    }
    if (next.equalsIgnoreCase("DeleteOrder")) {
      delete();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new ControllerImpl().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again ");
      start();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }

  @Override
  public void get() {
    StoreGetImpl.getStoreFindCommand().start();
  }

  @Override
  public void getInventory() {
    StoreInventoryImpl.getStoreInventoryCommand().start();
  }

  @Override
  public void create() {
    StoreCreateImpl.getStoreCreateCommand().start();
  }

  @Override
  public void delete() {
    StoreDeleteImpl.getStoreDeleteCommand().start();
  }

  @Override
  public void update() {
    start();
  }
}
