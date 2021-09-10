package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.interfaces.Controller;
import org.example.service.StoreServiceImpl;
import org.example.util.Validator;

import java.util.Scanner;

@NoArgsConstructor
public class StoreDeleteImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final StoreServiceImpl storeService = StoreServiceImpl.getStoreService();
  private static StoreDeleteImpl storeDeleteCommand;

  public static StoreDeleteImpl getStoreDeleteCommand() {
    if (storeDeleteCommand == null) {
      storeDeleteCommand = new StoreDeleteImpl();
    }
    return storeDeleteCommand;
  }

  @Override
  public void start() {
    System.out.print(" ENTER ORDER-ID \n \uD83D\uDC49 ");
    delete();
  }

  private void delete() {
    String orderId = scanner.next();
    if (Validator.validNumber(orderId)) {
      if (storeService.delete(Long.valueOf(orderId)) == 200) {
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
  }
}
