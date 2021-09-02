package org.example.controller.user;

import org.example.controller.Controller;
import org.example.controller.ControllerImpl;
import org.example.controller.Validator;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCreateController implements Controller {

  private final Scanner scanner = new ControllerImpl().getScanner();
  private final UserServiceImpl userService = new UserServiceImpl();
  private final Validator validator = new Validator();

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 USER\n \uD83D\uDC49 LIST \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("user")) {
      create();
      start();
    }
    if (next.equalsIgnoreCase("list")) {
      createList();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new UserControllerImpl().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.println("Try again");
      start();
    }
  }

  public void createList() {
    List<User> userList = new ArrayList<>();
    userService.createListUsers(userList);
  }

  public void create() {
    Integer id = Integer.valueOf(enterId());
    String userName = enterUserName();
    String firstName = enterFirstName();
    String lastName = enterLastName();
    Integer status = Integer.valueOf(enterStatus());
    String password = enterPassword();
    String email = enterEmail();
    String phone = enterPhone();
    userService.createNewUser(id, userName, firstName, lastName, status, password, email, phone);
  }

  private String enterId() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (!validator.validNumber(id)) {
      System.out.println("Try again");
      return enterId();
    }
    return id;
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!validator.validString(userName)) {
      System.out.println("Try again");
      return enterUserName();
    }
    return userName;
  }

  private String enterFirstName() {
    System.out.print(" ENTER FIRSTNAME \n \uD83D\uDC49 ");
    String firstName = scanner.next();
    if (!validator.validString(firstName)) {
      System.out.println("Try again");
      return enterLastName();
    }
    return firstName;
  }

  private String enterLastName() {
    System.out.print(" ENTER LASTNAME \n \uD83D\uDC49 ");
    String lastName = scanner.next();
    if (!validator.validString(lastName)) {
      System.out.println("Try again");
      return enterLastName();
    }
    return lastName;
  }

  private String enterStatus() {
    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");
    System.out.print(" EXAMPLES \n \uD83D\uDC49 200,300,400,404,415,500,505\n \uD83D\uDC49 ");
    String status = scanner.next();
    if (!validator.validNumber(status)) {
      System.out.println("Try again");
      return enterStatus();
    }
    if (status.length() > 3 | status.length() < 3) {
      System.out.println("Try again");
      return enterStatus();
    }
    return status;
  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!validator.validString(password)) {
      System.out.println("Try again");
      return enterPassword();
    }
    return password;
  }

  private String enterEmail() {
    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");
    String email = scanner.next();
    if (!validator.validString(email)) {
      System.out.println("Try again");
      return enterEmail();
    }
    if (!email.contains("@")) {
      System.out.println("Try again");
      return enterEmail();
    }
    return email;
  }

  private String enterPhone() {
    System.out.print(" ENTER NUMBER PHONE \n \uD83D\uDC49 ");
    String number = scanner.next();
    if (!validator.validNumber(number)) {
      System.out.println("Try again");
      return enterPhone();
    }
    return number;
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
