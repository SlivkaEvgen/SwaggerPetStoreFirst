package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.model.Pet;
import org.example.service.PetServiceImpl;
import java.util.Scanner;

// ok
public class PetGetCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void findById() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (Validator.validNumber(id)) {
      Pet byId = new PetServiceImpl().findById(Integer.valueOf(id));
      if (byId.getId() != 0) {
        System.out.println(" ✅ Successfully");
        System.out.println(byId);
      } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        findById();
      }
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      findById();
    }
  }

  private void findByStatus() {
    System.out.print(
        " ENTER STATUS \n EXAMPLES \uD83D\uDC49 available, pending, sold\n \uD83D\uDC49 ");
    String status = scanner.next();
    if (!Validator.validString(status)
        | !status.equalsIgnoreCase("available")
            & !status.equalsIgnoreCase("pending")
            & !status.equalsIgnoreCase("sold")) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      findByStatus();
    } else {
      if (new PetServiceImpl().findPetByStatus(status) == 200) {
        System.out.println(" ✅ Successfully");
      }
    }
  }

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 GetByID\n \uD83D\uDC49 GetByStatus\n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("GetByID")) {
      findById();
      start();
    }
    if (next.equalsIgnoreCase("GetByStatus")) {
      findByStatus();
      start();
    }
    if (next.equalsIgnoreCase("BACK")) {
      new PetControllerImpl().start();
    }
    if (next.equalsIgnoreCase("STOP")) {
      stop();
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
