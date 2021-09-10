package org.example.controller.user;import lombok.NoArgsConstructor;import org.example.config.ScannerConsole;import org.example.controller.interfaces.Controller;import java.util.Scanner;@NoArgsConstructorpublic class UserCreateImpl implements Controller {  private static UserCreateImpl userCreateController;  private final Scanner scanner = ScannerConsole.getInstance();  public static UserCreateImpl getUserCreateController() {    if (userCreateController == null) {      userCreateController = new UserCreateImpl();    }    return userCreateController;  }  private void create(){      String next = scanner.next();      if (next.equalsIgnoreCase("NewUSER")) {          UserCreateNewUserImpl.getUserCreateController().start();          start();      }      if (next.equalsIgnoreCase("ListUSERS")) {          UserCreateUsersListImpl.getUserCreateUsersListController().start();          start();      }      if (next.equalsIgnoreCase("stop")) {          stop();      }      if (next.equalsIgnoreCase("back")) {          UserControllerImpl.getUserController().start();      } else {          System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");          start();      }  }  @Override  public void start() {    System.out.print("\n \uD83D\uDC49 NewUSER\n \uD83D\uDC49 ListUSERS \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");   create();  }  @Override  public void stop() {    System.exit(0);  }}