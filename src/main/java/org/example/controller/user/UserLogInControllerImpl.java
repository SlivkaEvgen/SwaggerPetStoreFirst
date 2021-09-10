package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.service.UserServiceImpl;

@NoArgsConstructor
public class UserLogInControllerImpl implements Controller {

  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserLogInControllerImpl userLoginController;

  public static UserLogInControllerImpl getUserLoginController() {
    if (userLoginController == null) {
      userLoginController = new UserLogInControllerImpl();
    }
    return userLoginController;
  }

  private void logIn() {
    if (userService.loginUser(enterCommands.enterUserName(), enterCommands.enterPassword()) == 200) {
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
