package org.example.controller.store;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.model.Order;
import org.example.service.StoreServiceImpl;
import java.util.Scanner;
// done
public class StoreFindCommand implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    System.out.print(" ENTER ORDER-ID \n \uD83D\uDC49 ");
    String orderId = scanner.next();
    if (Validator.validNumber(orderId)) {
      Order orderById = new StoreServiceImpl().findOrderById(Integer.valueOf(orderId));
      if (orderById.getId() != null) {
        System.out.println(" ✅ Successfully");
        System.out.println(orderById);
      } else {
        System.out.print("\n      ⚠️ Not found ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        start();
      }
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
