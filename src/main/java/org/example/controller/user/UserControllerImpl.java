package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.ControllerImpl;
import org.example.controller.interfaces.UserController;

import java.util.Scanner;

@NoArgsConstructor
public class UserControllerImpl implements UserController {

  private static UserControllerImpl userController;
  private final Scanner scanner = ScannerConsole.getInstance();

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
      logIn();
      start();
    }
    if (next.equalsIgnoreCase("logout")) {
      logOut();
      start();
    }
    if (next.equalsIgnoreCase("get")) {
      get();
      start();
    }
    if (next.equalsIgnoreCase("create")) {
      create();
      start();
    }
    if (next.equalsIgnoreCase("update")) {
      update();
      start();
    }
    if (next.equalsIgnoreCase("delete")) {
      delete();
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
  }

  @Override
  public void logIn() {
    UserLogInImpl.getUserLoginController().start();
  }

  @Override
  public void logOut() {
    UserLogOutImpl.getUserLogOutController().start();
  }

  @Override
  public void get() {
    UserGetImpl.getUserGetController().start();
  }

  @Override
  public void create() {
    UserCreateImpl.getUserCreateController().start();
  }

  @Override
  public void update() {
    UserUpdateImpl.getUserUpdateController().start();
  }

  @Override
  public void delete() {
    UserDeleteImpl.getUserDeleteController().start();
  }
}
