package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.service.UserServiceImpl;
import org.example.util.Validator;

import java.util.Scanner;

@NoArgsConstructor
public class UserDeleteImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserDeleteImpl userDeleteController;

  public static UserDeleteImpl getUserDeleteController() {
    if (userDeleteController == null) {
      userDeleteController = new UserDeleteImpl();
    }
    return userDeleteController;
  }

  private void delete() {
    String username = scanner.next();
    if (Validator.validString(username)) {
      if (userService.delete(username) == 200) {
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Not found user ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        start();
      }
    } else {
      System.out.print("\n      ⚠️ Not found USER-NAME ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  @Override
  public void start() {
      System.out.print(" ENTER USER-NAME \n \uD83D\uDC49 ");
      delete();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
