package org.example.controller.user;

import org.example.service.UserServiceImpl;

public class UserLogOutController {

  public void logOut() {
    Integer logOutUser = new UserServiceImpl().logOutUser();
    if (logOutUser == 200) {
      System.out.println(" ✅ Successfully");
    } else {
        System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      logOut();
    }
  }
}
