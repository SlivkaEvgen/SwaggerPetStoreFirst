package org.example.controller.pet;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.model.Pet;
import org.example.service.PetServiceImpl;
import java.util.Scanner;

@NoArgsConstructor
public class PetUpdateCommandImpl implements Controller {

  private static PetUpdateCommandImpl petUpdateCommand;
  private final Scanner scanner = ScannerConsole.getInstance();
  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final PetServiceImpl petService = PetServiceImpl.getPetServiceImpl();

  public static PetUpdateCommandImpl getPetUpdateCommand() {
    if (petUpdateCommand == null) {
      petUpdateCommand = new PetUpdateCommandImpl();
    }
    return petUpdateCommand;
  }

  private void UpdatesWithFormData() {
      Long update =
        petService.update(
            enterCommands.enterId(),
            enterCommands.enterName(),
            enterCommands.enterStatus());
    System.out.println(update);
    if (update != 0) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
    }
  }

  private void UpdateAnExistingPet() {
      Pet update =
        petService.updatePut(
            enterCommands.enterId(),
            enterCommands.enterName(),
            enterCommands.enterStatus(),
            enterCommands.createCategory(),
            enterCommands.createListImages(),
            enterCommands.createTagList());
    System.out.println(update);
    if (update.getId() != null) {
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
  }
}
