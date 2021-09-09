package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCreateUsersListControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = UserServiceImpl.getUserService();
  private static UserCreateUsersListControllerImpl userCreateUsersListController;
  private final List<User> userList = new ArrayList<>();

  public static UserCreateUsersListControllerImpl getUserCreateUsersListController() {
    if (userCreateUsersListController == null) {
      userCreateUsersListController = new UserCreateUsersListControllerImpl();
    }
    return userCreateUsersListController;
  }

  private void completeList() {
    userService.createListUsers(userList);
  }

  private void getUser() {
    //    User user = UserCreateNewUserControllerImpl.getUserCreateController().createUser();
    userList.add(UserCreateNewUserControllerImpl.getUserCreateController().createUser());
    moreUsers();
  }

  private void moreUsers() {
    System.out.print("Create new user ? \n \uD83D\uDC49 yes \n \uD83D\uDC49 no \n \uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("yes")) {
      getUser();
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
