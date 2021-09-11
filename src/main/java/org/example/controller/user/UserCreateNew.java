package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.controller.interfaces.Controller;
import org.example.controller.EnterCommands;
import org.example.service.UserServiceImpl;

@NoArgsConstructor
public class UserCreateNew implements Controller {

  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserCreateNew userCreateNewController;

  public static UserCreateNew getUserCreateController() {
    if (userCreateNewController == null) {
      userCreateNewController = new UserCreateNew();
    }
    return userCreateNewController;
  }

  public Long createUser() {
    return userService.createNewUser(
        enterCommands.enterId(),
        enterCommands.enterUserName(),
        enterCommands.enterFirstName(),
        enterCommands.enterLastName(),
        enterCommands.enterEmail(),
        enterCommands.enterPassword(),
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
