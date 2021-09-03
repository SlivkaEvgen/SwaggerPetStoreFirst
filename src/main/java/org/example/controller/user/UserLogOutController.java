package org.example.controller.user;

import org.example.service.UserServiceImpl;

public class UserLogOutController {

  private final UserServiceImpl userService = new UserServiceImpl();

  public void logOut() {
    Integer logOutUser = userService.logOutUser();
    if (logOutUser == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.println(" ❌ Error, please try again");
      logOut();
    }
  }
}
