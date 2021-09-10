package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.example.util.Validator;
import java.util.Scanner;

@NoArgsConstructor
public class UserGetControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserGetControllerImpl userGetController;
  private static  User user;

  public static UserGetControllerImpl getUserGetController() {
    if (userGetController == null) {
      userGetController = new UserGetControllerImpl();
    }
    return userGetController;
  }

  private void getByName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
      if (Validator.validString(userName)) {
          user = userService.getByUserName(userName);
      if (user.getId() != null) {
        System.out.println(user);
        System.out.println(" ✅ Successfully");
      }else {
          System.out.print(
                  "\n   ⚠️ User not found ⚠️ \n \uD83D\uDCAC Please, enter again \n ");
          getByName();
      }
    } else {
      System.out.print(
          "\n   ⚠️ User not found ⚠️ \n \uD83D\uDCAC Please, enter again \n ");
          getByName();
    }
  }

  @Override
  public void start() {
      getByName();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
