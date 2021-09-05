package org.example.controller.store;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.StoreServiceImpl;
import java.util.Scanner;

public class StoreDeleteCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    delete();
  }

  private void delete() {
    System.out.print(" ENTER ORDER-ID \n \uD83D\uDC49 ");
    String orderId = scanner.next();
    if (Validator.validNumber(orderId)) {
      if (new StoreServiceImpl().delete(Integer.valueOf(orderId)) == 200) {
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Not found ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        start();
      }
    } else {
      System.out.print("\n      ⚠️ Not found ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
