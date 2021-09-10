package org.example.controller;

import org.example.config.ScannerConsole;
import org.example.controller.pet.PetControllerImpl;
import org.example.controller.store.StoreControllerImpl;
import org.example.controller.user.UserControllerImpl;

import java.util.Scanner;

public class CommandImpl implements Controller {

  private final PetControllerImpl petController = PetControllerImpl.getPetController();
  private final UserControllerImpl userController = UserControllerImpl.getUserController();
  private final StoreControllerImpl storeController = StoreControllerImpl.getStoreController();
  private final Scanner scanner = ScannerConsole.getInstance();
  private static CommandImpl command;

  public static CommandImpl getCommand() {
    if (command == null) {
      command = new CommandImpl();
    }
    return command;
  }

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 User\n \uD83D\uDC49 Pet\n \uD83D\uDC49 Store\n   \uD83D\uDC49 BACK\n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("user")) {
      userController.start();
      start();
    }
    if (next.equalsIgnoreCase("pet")) {
      petController.start();
      start();
    }
    if (next.equalsIgnoreCase("store")) {
      storeController.start();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      ControllerImpl.getController().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again ");
      start();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
