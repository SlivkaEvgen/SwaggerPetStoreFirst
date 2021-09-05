package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserGetControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void get() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    final UserServiceImpl userService = new UserServiceImpl();
    String userName = scanner.next();
    if (Validator.validString(userName) & userService.findById(userName).getId() != null) {
      System.out.println(userService.findById(userName));
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      get();
    }
  }

  @Override
  public void start() {
    get();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
