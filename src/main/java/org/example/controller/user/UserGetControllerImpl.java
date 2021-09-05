package org.example.controller.user;

import com.google.gson.JsonSyntaxException;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;
// done
public class UserGetControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void get() {
    try {
      String userName = enterUserName();
      System.out.println();
      if (new UserServiceImpl().findById(userName).getId() != 0) {
        System.out.println(" ✅ Successfully");
      } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
        get();
      }
    } catch (JsonSyntaxException t) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterUserName();
    }
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!Validator.validString(userName)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterUserName();
    }
    return userName;
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
