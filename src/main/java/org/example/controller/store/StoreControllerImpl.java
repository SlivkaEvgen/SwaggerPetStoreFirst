package org.example.controller.store;

import org.example.controller.CommandImpl;
import org.example.controller.ControllerImpl;
import java.util.Scanner;

public class StoreControllerImpl {

  private final Scanner scanner = new ControllerImpl().getScanner();

  public void startStore() {
    System.out.print(
        "\n \uD83D\uDC49 Inventory\n \uD83D\uDC49 PlaceAnOrder\n \uD83D\uDC49 FindPurchaseOrder \n \uD83D\uDC49 DeletePurchaseOrder \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("Inventory")) {
      // new CommandImpl().start();
    }
    if (next.equalsIgnoreCase("PlaceAnOrder")) {
      // new CommandImpl().start();
    }
    if (next.equalsIgnoreCase("FindPurchaseOrder")) {
      // new CommandImpl().start();
    }
    if (next.equalsIgnoreCase("DeletePurchaseOrder")) {
      // new CommandImpl().start();
    }
    if (next.equalsIgnoreCase("back")) {
      new CommandImpl().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    }
  }

  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
