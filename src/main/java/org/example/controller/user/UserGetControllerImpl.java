package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.example.util.Validator;
import java.util.Scanner;

public class UserGetControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserGetControllerImpl userGetController;

  public static UserGetControllerImpl getUserGetController() {
    if (userGetController == null) {
      userGetController = new UserGetControllerImpl();
    }
    return userGetController;
  }

  private void get() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    User user = userService.getByName(userName);
      if (Validator.validString(userName)& user.getId()!=null) {
      System.out.println(user);
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
  }
}
