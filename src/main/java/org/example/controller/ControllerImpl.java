package org.example.controller;

import org.example.config.ScannerConsole;

import java.util.Scanner;

public class ControllerImpl implements Controller {

  private static ControllerImpl controller;
  private final Scanner scanner = ScannerConsole.getInstance();

  public static ControllerImpl getController() {
    if (controller == null) {
      controller = new ControllerImpl();
    }
    return controller;
  }

  @Override
  public void start() {
    System.out.print(" HELLO!\uD83D\uDC4B\n");
    startConsole();
  }

  private void startConsole() {
    System.out.print("   \uD83D\uDC49 Start \n   \uD83D\uDC49 Stop\n\uD83D\uDC49 ");
    String start = scanner.next();
    if (start.equalsIgnoreCase("start")) {
      new CommandImpl().start();
    }
    if (start.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      startConsole();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
