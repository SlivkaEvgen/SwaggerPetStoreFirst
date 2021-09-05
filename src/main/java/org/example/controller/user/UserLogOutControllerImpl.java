package org.example.controller.user;

import org.example.controller.Controller;
import org.example.service.UserServiceImpl;
// ok
public class UserLogOutControllerImpl implements Controller {

  private void logOut() {
    if (new UserServiceImpl().logOutUser() == 200) {
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
