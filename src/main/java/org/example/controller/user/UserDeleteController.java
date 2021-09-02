package org.example.controller.user;

import org.example.controller.ControllerImpl;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserDeleteController {

  private final Scanner scanner = new ControllerImpl().getScanner();
  private final UserServiceImpl userService = new UserServiceImpl();
  private final Validator validator = new Validator();

  public void delete() {
    System.out.print(" ENTER USER-NAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (validator.validString(userName)) {
      userService.delete(userName);
    } else {
      System.out.println("Try again");
    }
  }
}
