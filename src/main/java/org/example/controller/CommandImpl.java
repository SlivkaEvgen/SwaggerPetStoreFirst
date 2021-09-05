package org.example.controller;

import okhttp3.internal.http2.ConnectionShutdownException;
import org.example.config.ScannerConsole;
import org.example.controller.pet.PetControllerImpl;
import org.example.controller.store.StoreControllerImpl;
import org.example.controller.user.UserControllerImpl;
import java.util.Scanner;

public class CommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() throws ConnectionShutdownException, InterruptedException {
    System.out.print(
        "\n \uD83D\uDC49 User\n \uD83D\uDC49 Pet\n \uD83D\uDC49 Store\n   \uD83D\uDC49 BACK\n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("user")) {
      new UserControllerImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("pet")) {
      new PetControllerImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("store")) {
      new StoreControllerImpl().start();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new ControllerImpl().start();
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
    scanner.close();
  }
}
