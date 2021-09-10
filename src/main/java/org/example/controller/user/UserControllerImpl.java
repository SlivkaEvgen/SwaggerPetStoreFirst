package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.CommandImpl;
import org.example.controller.Controller;
import java.util.Scanner;

@NoArgsConstructor
public class UserControllerImpl implements Controller {

  private static UserControllerImpl userController;
  private final Scanner scanner = ScannerConsole.getInstance();
//  private final UserLogInControllerImpl userLogInController = UserLogInControllerImpl.getUserLoginController();
//  private final UserLogOutControllerImpl userLogOutController = UserLogOutControllerImpl.getUserLogOutController();
//  private final UserGetControllerImpl userGetController = UserGetControllerImpl.getUserGetController();
//  private final UserCreateControllerImpl userCreateController = UserCreateControllerImpl.getUserCreateController();
//  private final UserUpdateControllerImpl userUpdateController = UserUpdateControllerImpl.getUserUpdateController();
//  private final UserDeleteControllerImpl userDeleteController = UserDeleteControllerImpl.getUserDeleteController();

  public static UserControllerImpl getUserController() {
    if (userController == null) {
      userController = new UserControllerImpl();
    }
    return userController;
  }

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 LOGIN \n \uD83D\uDC49 LOGOUT \n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("login")) {
        UserLogInControllerImpl.getUserLoginController().start();
      start();
    }
    if (next.equalsIgnoreCase("logout")) {
        UserLogOutControllerImpl.getUserLogOutController().start();
      start();
    }
    if (next.equalsIgnoreCase("get")) {
        UserGetControllerImpl.getUserGetController().start();
      start();
    }
    if (next.equalsIgnoreCase("create")) {
        UserCreateControllerImpl.getUserCreateController().start();
      start();
    }
    if (next.equalsIgnoreCase("update")) {
        UserUpdateControllerImpl.getUserUpdateController().start();
      start();
    }
    if (next.equalsIgnoreCase("delete")) {
        UserDeleteControllerImpl.getUserDeleteController().start();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new CommandImpl().start();
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
