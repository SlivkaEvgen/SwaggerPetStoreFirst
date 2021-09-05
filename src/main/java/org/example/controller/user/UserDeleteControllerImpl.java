package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserDeleteControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void delete() {
    System.out.print(" ENTER USER-NAME \n \uD83D\uDC49 ");
    String username = scanner.next();
    if (Validator.validString(username)) {
      if (new UserServiceImpl().delete(username) == 200) {
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Not found ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        start();
      }
    } else {
      System.out.print("\n      ⚠️ Not found ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  @Override
  public void start() {
    delete();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
