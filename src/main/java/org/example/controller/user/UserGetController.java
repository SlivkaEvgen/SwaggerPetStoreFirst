package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserGetController {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = new UserServiceImpl();

  public void get() {
    String userName = enterUserName();
    System.out.println();
    Integer user = userService.getUser(userName);
    if (user == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.println(" ❌ Error, please try again");
      get();
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
}
