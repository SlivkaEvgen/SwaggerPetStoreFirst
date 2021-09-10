package org.example.controller.user;

import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.model.User;
import org.example.service.UserServiceImpl;

public class UserCreateNewUserControllerImpl implements Controller {

  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserCreateNewUserControllerImpl userCreateNewUserController;

  public static UserCreateNewUserControllerImpl getUserCreateController() {
    if (userCreateNewUserController == null) {
      userCreateNewUserController = new UserCreateNewUserControllerImpl();
    }
    return userCreateNewUserController;
  }

  public Long createUser() {
    return userService.createNewUser(
        enterCommands.enterId(),
        enterCommands.enterUserName(),
        enterCommands.enterFirstName(),
        enterCommands.enterLastName(),
        enterCommands.enterPassword(),
        enterCommands.enterEmail(),
        enterCommands.enterPhone());
  }

  @Override
  public void start() {
    if (createUser() == 200) {
      System.out.println(" ✅ Successfully");
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
