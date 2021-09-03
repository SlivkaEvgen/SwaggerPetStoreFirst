package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserLogInController {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = new UserServiceImpl();

  public void logIn() {
    String userName = enterUserName();
    String password = enterPassword();
    Integer loginUser = userService.loginUser(userName, password);
    if (loginUser == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.println(" ❌ Error, please try again");
      logIn();
    }
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!Validator.validString(userName)) {
      System.out.println("Try again");
      enterUserName();
    }
    return userName;
  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!Validator.validString(password)) {
      System.out.println("Try again");
      enterPassword();
    }
    return password;
  }
}
