package org.example.controller.user;

import org.example.controller.ControllerImpl;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserGetController {

  private final Scanner scanner = new ControllerImpl().getScanner();
  private final UserServiceImpl userService = new UserServiceImpl();
  private final Validator validator = new Validator();

  public void get() {
    String userName = enterUserName();
    System.out.println();
    userService.getUser(userName);
  }

  public String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!validator.validString(userName)) {
      System.out.println("Try again");
      enterUserName();
    }
    return userName;
  }
}