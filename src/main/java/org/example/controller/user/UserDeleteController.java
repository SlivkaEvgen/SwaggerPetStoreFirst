package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;
//done
public class UserDeleteController implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void delete() {
    System.out.print(" ENTER USER-NAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (Validator.validString(userName)) {
      if (new UserServiceImpl().delete(userName) == 200) {
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        delete();
      }
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      delete();
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
