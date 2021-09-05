package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserLogInControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void logIn() {
    final EnterCommands enterCommands = new EnterCommands();
    if (new UserServiceImpl().loginUser(enterCommands.enterName(), enterCommands.enterPassword())
        == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      logIn();
    }
  }

  @Override
  public void start() {
    logIn();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
