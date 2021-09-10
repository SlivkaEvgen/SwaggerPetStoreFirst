package org.example.controller.user;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.model.User;
import org.example.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class UserCreateUsersListControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final List<User> userList = new ArrayList<>();
  private static UserCreateUsersListControllerImpl userCreateUsersListController;

  public static UserCreateUsersListControllerImpl getUserCreateUsersListController() {
    if (userCreateUsersListController == null) {
      userCreateUsersListController = new UserCreateUsersListControllerImpl();
    }
    return userCreateUsersListController;
  }

  private void completeList() {
    if (userService.createListUsers(userList) == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      completeList();
    }
  }

  private void createUser() {
    User user = new User();
    user.setId(enterCommands.enterId());
    user.setUserName(enterCommands.enterUserName());
    user.setFirstName(enterCommands.enterFirstName());
    user.setLastName(enterCommands.enterLastName());
    user.setEmail(enterCommands.enterEmail());
    user.setPassword(enterCommands.enterPassword());
    user.setPhone(enterCommands.enterPhone());
    user.setUserStatus(200);
    System.out.println(user);
    userList.add(user);
    moreUsers();
  }

  private void moreUsers() {
    System.out.print("Create new user ? \n \uD83D\uDC49 yes \n \uD83D\uDC49 no \n \uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("yes")) {
        createUser();
    }
    if (next.equalsIgnoreCase("no")) {
      completeList();
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      moreUsers();
    }
  }

  @Override
  public void start() {
    moreUsers();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
