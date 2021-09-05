package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.service.PetServiceImpl;
import java.util.Scanner;
// ok
public class PetUpdateCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final EnterCommands enterCommands = new EnterCommands();

  private void UpdatesWithFormData() {
    Integer update =
        new PetServiceImpl()
            .update(
                Integer.valueOf(enterCommands.enterId()),
                enterCommands.enterName(),
                enterCommands.enterStatus(),
                enterCommands.createCategory(),
                enterCommands.createListImages(),
                enterCommands.createTagList());
    System.out.println(update);
    if (update != 0) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
    }
  }

  private void UpdateAnExistingPet() {
    Integer update =
        new PetServiceImpl()
            .updatePut(
                Integer.valueOf(enterCommands.enterId()),
                enterCommands.enterName(),
                enterCommands.enterStatus(),
                enterCommands.createCategory(),
                enterCommands.createListImages(),
                enterCommands.createTagList());
    System.out.println(update);
    if (update != 0) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
    }
  }

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 UpdatesWithFormData\n \uD83D\uDC49 UpdateAnExistingPet\n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("UpdatesWithFormData")) {
      UpdatesWithFormData();
      start();
    }

    if (next.equalsIgnoreCase("UpdateAnExistingPet")) {
      UpdateAnExistingPet();
      start();
    }

    if (next.equalsIgnoreCase("back")) {
      new PetControllerImpl().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
