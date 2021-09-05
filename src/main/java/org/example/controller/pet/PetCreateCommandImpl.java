package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.model.Pet;
import org.example.service.PetServiceImpl;
import java.util.Scanner;
// ok
public class PetCreateCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final EnterCommands enterCommands = new EnterCommands();

  private void create() {
   Pet pet = new PetServiceImpl().create(Integer.valueOf(enterCommands.enterId()),
                 enterCommands.enterName(),
                 enterCommands.enterStatus(),
                 enterCommands.createCategory(),
                 enterCommands.createListImages(),
                 enterCommands.createTagList());
    System.out.println(pet);
    if (pet.getId() != 0) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
    }
  }

  @Override
  public void start() {
    create();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
