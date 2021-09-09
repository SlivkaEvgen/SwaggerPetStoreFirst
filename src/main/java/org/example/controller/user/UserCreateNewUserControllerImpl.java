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

  public User createUser() {
    User newUser =
        userService.createNewUser(
            enterCommands.enterId(),
            enterCommands.enterName(),
            enterCommands.enterFirstName(),
            enterCommands.enterLastName(),
            enterCommands.enterPassword(),
            enterCommands.enterEmail(),
            enterCommands.enterPhone());
    System.out.println(" ✅ Successfully");
    return newUser;
  }

  @Override
  public void start() {
    createUser();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
