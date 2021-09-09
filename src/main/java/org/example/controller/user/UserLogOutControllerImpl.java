package org.example.controller.user;

import org.example.controller.Controller;
import org.example.service.UserServiceImpl;

public class UserLogOutControllerImpl implements Controller {

  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserLogOutControllerImpl userLogOutController;

  public static UserLogOutControllerImpl getUserLogOutController() {
    if (userLogOutController == null) {
      userLogOutController = new UserLogOutControllerImpl();
    }
    return userLogOutController;
  }

  private void logOut() {
    if (userService.logOutUser() == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      logOut();
    }
  }

  @Override
  public void start() {
    logOut();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
