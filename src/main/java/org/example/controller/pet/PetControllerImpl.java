package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.CommandImpl;
import java.util.Scanner;
// done
public class PetControllerImpl {

  private final Scanner scanner = ScannerConsole.getInstance();

  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 UPLOAD-IMAGE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("get")) {
      new PetGetCommandImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("create")) {
      new PetCreateCommandImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("update")) {
      new PetUpdateCommandImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("upload-image")) {
      new PetUpLoadImageCommandImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("delete")) {
      new PetDeleteCommandImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new CommandImpl().start();
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
    scanner.close();
  }
}
