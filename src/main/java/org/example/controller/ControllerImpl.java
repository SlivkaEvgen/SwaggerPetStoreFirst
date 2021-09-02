package org.example.controller;

import java.util.Scanner;

public class ControllerImpl implements Controller {

  private final Scanner scanner = new Scanner(System.in);

  @Override
  public void start() {
    System.out.print(" HELLO!\uD83D\uDC4B\n");
    startConsole();
  }

  private void startConsole() {
    System.out.print("   \uD83D\uDC49 Start \n   \uD83D\uDC49 Stop\n\uD83D\uDC49 ");
    String start = getScanner().next();
    if (start.equalsIgnoreCase("start")) {
      new CommandImpl().start();
    }
    if (start.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
      startConsole();
    }
  }

  public Scanner getScanner() {
    return scanner;
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
