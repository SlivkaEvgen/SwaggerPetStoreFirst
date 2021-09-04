package org.example.controller.user;

import com.google.gson.JsonSyntaxException;
import org.example.config.ScannerConsole;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserGetController {

  private final Scanner scanner = ScannerConsole.getInstance();

  public void get() {
      try{
    String userName = enterUserName();
    System.out.println();
    Integer user = new UserServiceImpl().getUser(userName);
    if (user == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      get();
    }
    }catch (JsonSyntaxException t) {
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
}
