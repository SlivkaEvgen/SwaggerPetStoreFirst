package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.example.util.Validator;

import java.util.Scanner;

@NoArgsConstructor
public class UserGetImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserGetImpl userGetController;

  public static UserGetImpl getUserGetController() {
    if (userGetController == null) {
      userGetController = new UserGetImpl();
    }
    return userGetController;
  }

  private void getByName() {
    String userName = scanner.next();
    if (Validator.validString(userName)) {
      User user = userService.getByUserName(userName);
      if (user.getId() != null) {
        System.out.println(user);
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n   ⚠️ User not found ⚠️ \n \uD83D\uDCAC Please, enter again \n ");
        start();
      }
    } else {
      System.out.print("\n   ⚠️ User not found ⚠️ \n \uD83D\uDCAC Please, enter again \n ");
      start();
    }
  }

  @Override
  public void start() {
      System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
      getByName();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
