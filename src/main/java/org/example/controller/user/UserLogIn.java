package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.controller.interfaces.Controller;
import org.example.controller.EnterCommands;
import org.example.service.UserServiceImpl;

@NoArgsConstructor
public class UserLogIn implements Controller {

  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserLogIn userLoginController;

  public static UserLogIn getUserLoginController() {
    if (userLoginController == null) {
      userLoginController = new UserLogIn();
    }
    return userLoginController;
  }

  private void logIn() {
      Long status = userService.loginUser(enterCommands.enterUserName(), enterCommands.enterPassword());
    if (status == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n");
      logIn();
    }
  }

  @Override
  public void start() {
    logIn();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
