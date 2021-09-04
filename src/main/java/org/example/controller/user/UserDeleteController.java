package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserDeleteController {

  private final Scanner scanner = ScannerConsole.getInstance();

  public void delete() {
    System.out.print(" ENTER USER-NAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (Validator.validString(userName)) {
      int delete = new UserServiceImpl().delete(userName);
      if (delete == 200) {
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
}
