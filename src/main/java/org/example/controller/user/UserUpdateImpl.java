package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.service.UserServiceImpl;

@NoArgsConstructor
public class UserUpdateImpl implements Controller {

  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private static UserUpdateImpl userUpdateController;

  public static UserUpdateImpl getUserUpdateController() {
    if (userUpdateController == null) {
      userUpdateController = new UserUpdateImpl();
    }
    return userUpdateController;
  }

  private void update() {
    Long update =
        userService.update(
            enterCommands.enterId(),
            enterCommands.enterUserName(),
            enterCommands.enterFirstName(),
            enterCommands.enterLastName(),
            enterCommands.enterPassword(),
            enterCommands.enterEmail(),
            enterCommands.enterPhone());
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
