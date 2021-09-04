package org.example.controller.store;

import org.example.config.ScannerConsole;
import org.example.controller.CommandImpl;
import org.example.controller.Controller;
import java.util.Scanner;
// done
public class StoreControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 Inventory\n \uD83D\uDC49 CreateOrder\n \uD83D\uDC49 FindOrder \n \uD83D\uDC49 DeleteOrder \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("Inventory")) {
      new StoreInventoryCommand().start();
      start();
    }
    if (next.equalsIgnoreCase("CreateOrder")) {
      new StoreCreateCommand().start();
      start();
    }
    if (next.equalsIgnoreCase("FindOrder")) {
      new StoreFindCommand().start();
      start();
    }
    if (next.equalsIgnoreCase("DeleteOrder")) {
      new StoreDeleteCommand().start();
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
    scanner.close();
  }
}
