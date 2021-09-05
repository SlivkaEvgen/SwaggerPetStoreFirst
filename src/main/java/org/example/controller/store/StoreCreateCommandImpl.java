package org.example.controller.store;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.StoreServiceImpl;
import java.util.Scanner;
// done
public class StoreCreateCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    String id = enterId();
    String petId = enterPetId();
    String quantity = enterQuantity();
    String status = enterStatus();
    Integer integer =
        new StoreServiceImpl()
            .placeAnOrderForAPet(
                Integer.valueOf(id), Integer.valueOf(petId), Integer.valueOf(quantity), status);
    if (integer == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  private String enterId() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterId();
    }
    return id;
  }

  private String enterPetId() {
    System.out.print(" ENTER PET-ID \n \uD83D\uDC49 ");
    String petId = scanner.next();
    if (!Validator.validNumber(petId)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterPetId();
    }
    return petId;
  }

  private String enterQuantity() {
    System.out.print(" ENTER QUANTITY \n \uD83D\uDC49 ");
    String quantity = scanner.next();
    if (!Validator.validNumber(quantity)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterQuantity();
    }
    return quantity;
  }

  private String enterStatus() {
    System.out.print(" ENTER STATUS \n \uD83D\uDC49 ");
    System.out.print(" EXAMPLES  \uD83D\uDC49 placed, approved, delivered \n \uD83D\uDC49 ");
    String status = scanner.next();
    if (!Validator.validString(status)
        | !status.equalsIgnoreCase("placed")
            & !status.equalsIgnoreCase("approved")
            & !status.equalsIgnoreCase("delivered")) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterStatus();
    }
    return status;
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
