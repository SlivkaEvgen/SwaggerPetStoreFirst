package org.example.controller.pet;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.service.PetServiceImpl;
import org.example.util.Validator;

import java.util.Scanner;

@NoArgsConstructor
public class PetDeleteCommandImpl implements Controller {

  private static PetDeleteCommandImpl petDeleteCommand;
  private final Scanner scanner = ScannerConsole.getInstance();
  private final PetServiceImpl petService = PetServiceImpl.getPetServiceImpl();

  public static PetDeleteCommandImpl getPetDeleteCommand() {
    if (petDeleteCommand == null) {
      petDeleteCommand = new PetDeleteCommandImpl();
    }
    return petDeleteCommand;
  }

  private void delete() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (Validator.validNumber(id)) {
      if (petService.delete(Long.valueOf(id)) == 200) {
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        delete();
      }
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      delete();
    }
  }

  @Override
  public void start() {
    delete();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
