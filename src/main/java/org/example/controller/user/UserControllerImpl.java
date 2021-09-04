package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.CommandImpl;
import org.example.controller.Controller;
import java.util.Scanner;

public class UserControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 LOGIN \n \uD83D\uDC49 LOGOUT \n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("login")) {
      new UserLogInController().logIn();
      start();
    }
    if (next.equalsIgnoreCase("logout")) {
      new UserLogOutController().logOut();
      start();
    }
    if (next.equalsIgnoreCase("get")) {
      new UserGetController().get();
      start();
    }
    if (next.equalsIgnoreCase("create")) {
      new UserCreateController().start();
      start();
    }
    if (next.equalsIgnoreCase("update")) {
      new UserUpdateController().update();
      start();
    }
    if (next.equalsIgnoreCase("delete")) {
      new UserDeleteController().delete();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new CommandImpl().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    }else{
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
