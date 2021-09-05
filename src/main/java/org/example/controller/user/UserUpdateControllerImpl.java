package org.example.controller.user;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.UserServiceImpl;
import java.util.Scanner;
// done
public class UserUpdateControllerImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void update() {
    String userName = enterUserName();
    Integer id = Integer.valueOf(enterId());
    String firstName = enterFirstName();
    String lastName = enterLastName();
    Integer status = 200;
    String password = enterPassword();
    String email = enterEmail();
    String phone = enterPhone();
    Integer update =
        new UserServiceImpl()
            .update(id, userName, firstName, lastName, status, password, email, phone);
    if (update == 200) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      update();
    }
  }

  private String enterId() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (Validator.validNumber(id)) {
      return id;
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again ");
      enterId();
    }
    return id;
  }

  private String enterUserName() {
    System.out.print(" ENTER USERNAME \n \uD83D\uDC49 ");
    String userName = scanner.next();
    if (!Validator.validString(userName)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterUserName();
    }
    return userName;
  }

  private String enterFirstName() {
    System.out.print(" ENTER FIRSTNAME \n \uD83D\uDC49 ");
    String firstName = scanner.next();
    if (!Validator.validString(firstName)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterLastName();
    }
    return firstName;
  }

  private String enterLastName() {
    System.out.print(" ENTER LASTNAME \n \uD83D\uDC49 ");
    String lastName = scanner.next();
    if (!Validator.validString(lastName)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterLastName();
    }
    return lastName;
  }

  private String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!Validator.validString(password)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterPassword();
    }
    return password;
  }

  private String enterEmail() {
    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");
    String email = scanner.next();
    if (!Validator.validString(email)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterEmail();
    }
    if (!email.contains("@")) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterEmail();
    }
    return email;
  }

  private String enterPhone() {
    System.out.print(" ENTER NUMBER PHONE \n \uD83D\uDC49 ");
    String number = scanner.next();
    if (!Validator.validNumber(number)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      enterPhone();
    }
    return number;
  }

  @Override
  public void start() {
    update();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
