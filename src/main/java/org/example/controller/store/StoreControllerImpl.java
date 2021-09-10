package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.CommandImpl;
import org.example.controller.Controller;
import java.util.Scanner;

@NoArgsConstructor
public class StoreControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final StoreInventoryCommandImpl storeInventoryCommand = StoreInventoryCommandImpl.getStoreInventoryCommand();
  private final StoreCreateCommandImpl storeCreateCommand = StoreCreateCommandImpl.getStoreCreateCommand();
  private final StoreFindCommandImpl storeFindCommand = StoreFindCommandImpl.getStoreFindCommand();
  private final StoreDeleteCommandImpl storeDeleteCommand = StoreDeleteCommandImpl.getStoreDeleteCommand();
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
      storeInventoryCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("CreateOrder")) {
      storeCreateCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("FindOrder")) {
      storeFindCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("DeleteOrder")) {
      storeDeleteCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
        new CommandImpl().start();
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
}
