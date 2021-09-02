package org.example.controller.user;

import org.example.controller.ControllerImpl;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserLogInController {

  private final Scanner scanner = new ControllerImpl().getScanner();
  private final UserServiceImpl userService = new UserServiceImpl();
  private final Validator validator = new Validator();

  public void logIn() {
    String userName = enterUserName();
    String password = enterPassword();
    userService.loginUser(userName, password);
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!validator.validString(userName)) {
      System.out.println("Try again");
      enterUserName();
    }
    return userName;
  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!validator.validString(password)) {
      System.out.println("Try again");
      enterPassword();
    }
    return password;
  }
}
