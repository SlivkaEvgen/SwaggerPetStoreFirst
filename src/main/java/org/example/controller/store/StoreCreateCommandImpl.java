package org.example.controller.store;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.model.Order;
import org.example.service.StoreServiceImpl;
import java.util.Scanner;

public class StoreCreateCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    final EnterCommands enterCommands = new EnterCommands();
    Order order =
        new StoreServiceImpl()
            .placeAnOrderForAPet(
                Integer.valueOf(enterCommands.enterId()),
                Integer.valueOf(enterCommands.enterPetId()),
                Integer.valueOf(enterCommands.enterQuantity()),
                enterCommands.enterStatusStore());
    if (order.getId() != null) {
      System.out.println(" ✅ Successfully");
      System.out.println(order);
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
