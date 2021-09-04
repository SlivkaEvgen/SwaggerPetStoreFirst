package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserLogInController {

  private final Scanner scanner = ScannerConsole.getInstance();

  public void logIn() {
    String userName = enterUserName();
    String password = enterPassword();
    Integer loginUser = new UserServiceImpl().loginUser(userName, password);
    if (loginUser == 200) {
      System.out.println(" ✅ Successfully");
    } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      logIn();
    }
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!Validator.validString(userName)) {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterUserName();
    }
    return userName;
  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!Validator.validString(password)) {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterPassword();
    }
    return password;
  }
}
