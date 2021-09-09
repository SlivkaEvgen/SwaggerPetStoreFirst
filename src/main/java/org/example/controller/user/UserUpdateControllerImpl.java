package org.example.controller.user;

import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.service.UserServiceImpl;

public class UserUpdateControllerImpl implements Controller {

  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private static UserUpdateControllerImpl userUpdateController;

  public static UserUpdateControllerImpl getUserUpdateController() {
    if (userUpdateController == null) {
      userUpdateController = new UserUpdateControllerImpl();
    }
    return userUpdateController;
  }

  private void update() {
    Long update = userService.update(enterCommands.enterId(), enterCommands.enterName(), 200);
    if (update == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      update();
    }
  }

  @Override
  public void start() {
    update();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
