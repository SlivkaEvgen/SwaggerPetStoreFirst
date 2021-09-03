package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;

public class UserUpdateController {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final UserServiceImpl userService = new UserServiceImpl();

  public void update() {
    Integer id = Integer.valueOf(enterId());
    String userName = enterUserName();
    String firstName = enterFirstName();
    String lastName = enterLastName();
    Integer status = 200;
    String password = enterPassword();
    String email = enterEmail();
    String phone = enterPhone();
    Integer update =
        userService.update(id, userName, firstName, lastName, status, password, email, phone);
    if (update == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.println(" ❌ Error, please try again");
      update();
    }
  }

  private String enterId() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (Validator.validNumber(id)) {
      return id;
    } else {
      System.out.println("Try again");
      enterId();
    }
    return id;
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!Validator.validString(userName)) {
      System.out.println("Try again");
      enterUserName();
    }
    return userName;
  }

  private String enterFirstName() {
    System.out.print(" ENTER FIRSTNAME \n \uD83D\uDC49 ");
    String firstName = scanner.next();
    if (!Validator.validString(firstName)) {
      System.out.println("Try again");
      enterLastName();
    }
    return firstName;
  }

  private String enterLastName() {
    System.out.print(" ENTER LASTNAME \n \uD83D\uDC49 ");
    String lastName = scanner.next();
    if (!Validator.validString(lastName)) {
      System.out.println("Try again");
      enterLastName();
    }
    return lastName;
  }

  //  private String enterStatus() {
  //    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");
  //    System.out.print(" EXAMPLES \n \uD83D\uDC49 200,300,400,404,415,500,505\n \uD83D\uDC49 ");
  //    String status = scanner.next();
  //    if (!validator.validNumber(status)) {
  //      System.out.println("Try again");
  //      enterStatus();
  //    }
  //    if (status.length() > 3 | status.length() < 3) {
  //      System.out.println("Try again");
  //      enterStatus();
  //    }
  //    return status;
  //  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!Validator.validString(password)) {
      System.out.println("Try again");
      enterPassword();
    }
    return password;
  }

  private String enterEmail() {
    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");
    String email = scanner.next();
    if (!Validator.validString(email)) {
      System.out.println("Try again");
      enterEmail();
    }
    if (!email.contains("@")) {
      System.out.println("Try again");
      enterEmail();
    }
    return email;
  }

  private String enterPhone() {
    System.out.print(" ENTER NUMBER PHONE \n \uD83D\uDC49 ");
    String number = scanner.next();
    if (!Validator.validNumber(number)) {
      System.out.println("Try again");
      enterPhone();
    }
    return number;
  }
}
