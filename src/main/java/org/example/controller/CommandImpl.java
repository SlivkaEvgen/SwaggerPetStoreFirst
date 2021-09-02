package org.example.controller;

import org.example.controller.user.UserControllerImpl;
import java.util.Scanner;

public class CommandImpl implements Controller {

  private final Scanner scanner = new ControllerImpl().getScanner();

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 User\n \uD83D\uDC49 Pet\n \uD83D\uDC49 Store\n   \uD83D\uDC49 BACK\n   \uD83D\uDC49 STOP\n\uD83D\uDC49");
    String next = scanner.next();
    if (next.equalsIgnoreCase("user")) {
      new UserControllerImpl().start();
    }
    if (next.equalsIgnoreCase("pet")) {}
    if (next.equalsIgnoreCase("store")) {}
    if (next.equalsIgnoreCase("back")) {
      new ControllerImpl().start();
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
