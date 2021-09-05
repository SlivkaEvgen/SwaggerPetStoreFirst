package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;
// ok
public class UserLogInControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void logIn() {
    if (new UserServiceImpl().loginUser(enterUserName(), enterPassword()) == 200) {
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
      return enterUserName();
    }
    return userName;
  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!Validator.validString(password)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterPassword();
    }
    return password;
  }

  @Override
  public void start() {
    logIn();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
