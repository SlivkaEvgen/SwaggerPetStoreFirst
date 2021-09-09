package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.CommandImpl;

import java.util.Scanner;

public class PetControllerImpl {

  private static PetControllerImpl petController;// = getPetController();
  private final Scanner scanner = ScannerConsole.getInstance();
  private final PetGetCommandImpl petGetCommand = PetGetCommandImpl.getPetGetCommand();
  private final PetCreateCommandImpl petCreateCommand = PetCreateCommandImpl.getPetCreateCommand();
  private final PetUpdateCommandImpl petUpdateCommand = PetUpdateCommandImpl.getPetUpdateCommand();
  private final PetUpLoadImageCommandImpl petUpLoadImageCommand = PetUpLoadImageCommandImpl.getPetUpLoadImageCommand();
  private final PetDeleteCommandImpl petDeleteCommand = PetDeleteCommandImpl.getPetDeleteCommand();

  public static PetControllerImpl getPetController() {
    if (petController == null) {
      petController = new PetControllerImpl();
    }
    return petController;
  }

  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 UPLOAD-IMAGE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("get")) {
      petGetCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("create")) {
      petCreateCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("update")) {
      petUpdateCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("upload-image")) {
      petUpLoadImageCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("delete")) {
      petDeleteCommand.start();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
        new CommandImpl().start();
        //   command.start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  public void stop() {
    System.exit(0);
  }
}
