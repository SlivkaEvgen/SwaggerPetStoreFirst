package org.example.controller.validators;

public class UserController {

  private String id;
  private Integer userStatus;
  private String userName;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  String wrong = "\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n";
    public static void testValid(){
        String regex = "\\d+";

  // positive test cases, should all be "true"
        System.out.println("1".matches(regex));
        System.out.println("12345".matches(regex));
        System.out.println("123456789".matches(regex));

  // negative test cases, should all be "false"
        System.out.println("".matches(regex));
        System.out.println("foo".matches(regex));
        System.out.println("aa123bb".matches(regex));
    }

    public static String notNumbers(String id) {
      //    if (id.isEmpty()) {
      //      System.out.print(" ID is empty ");
      //
      //    }
      //    if (id.length() > 15) {
      //      System.out.println(" Length  more than 15 ");
      //
      //    }
      //    if (id.contains("\\d+")) {// if has 12345 - true else false
      //      // System.out.println("Name contains numbers");
      //      //validId(id);
      //    }else {
      //        return id;
      //    }
      return id;
    }

  private static Boolean enter(String name) {
    System.out.println("Enter name");
    return validIdBool(name);
  }

  public static Boolean validIdBool(String name) {
    if (name.isEmpty() | name.contains("\\d+") | name.length() >= 15) {
      return false;
    }
    return true;
  }

  public static String validId(String name) {

    if (!validIdBool(name)) {
      System.out.println("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return "false";
    }
    return name;
  }
}
