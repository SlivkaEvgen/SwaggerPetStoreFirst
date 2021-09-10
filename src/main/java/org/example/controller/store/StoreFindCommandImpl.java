package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.model.Order;
import org.example.service.StoreServiceImpl;
import org.example.util.Validator;
import java.util.Scanner;

@NoArgsConstructor
public class StoreFindCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final StoreServiceImpl storeService = StoreServiceImpl.getStoreService();
  private static StoreFindCommandImpl storeFindCommand;

  public static StoreFindCommandImpl getStoreFindCommand() {
    if (storeFindCommand == null) {
      storeFindCommand = new StoreFindCommandImpl();
    }
    return storeFindCommand;
  }

  @Override
  public void start() {
    System.out.print(" ENTER ORDER-ID \n \uD83D\uDC49 ");
    String orderId = scanner.next();
    if (Validator.validNumber(orderId)) {
      Order byId = storeService.findById(Long.valueOf(orderId));
      if (byId.getId() != null) {
        System.out.println(byId);
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
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
  }
}
