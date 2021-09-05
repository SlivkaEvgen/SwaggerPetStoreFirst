package org.example.controller;

import org.example.config.ScannerConsole;
import org.example.model.Category;
import org.example.model.Tag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterCommands implements Controller {

  private final List<Object> tagList = new ArrayList<>();
  private final List<Object> imagesList = new ArrayList<>();
  private final Scanner scanner = ScannerConsole.getInstance();
  private String id, name;

  public String enterId() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterId();
    }
    return id;
  }

  public String enterName() {
    System.out.print(" ENTER NAME \n \uD83D\uDC49 ");
    name = scanner.next();
    if (!Validator.validString(name)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterName();
    }
    return name;
  }

  public String enterFirstName() {
    System.out.print(" ENTER FIRSTNAME \n \uD83D\uDC49 ");
    String firstName = scanner.next();
    if (!Validator.validString(firstName)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterFirstName();
    }
    return firstName;
  }

  public String enterLastName() {
    System.out.print(" ENTER LASTNAME \n \uD83D\uDC49 ");
    String lastName = scanner.next();
    if (!Validator.validString(lastName)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterLastName();
    }
    return lastName;
  }

  public String enterPassword() {
    System.out.print(" ENTER PASSWORD \n \uD83D\uDC49 ");
    String password = scanner.next();
    if (!Validator.validString(password)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterPassword();
    }
    return password;
  }

  public String enterEmail() {
    System.out.print(" ENTER EMAIL \n \uD83D\uDC49 ");
    String email = scanner.next();
    if (!Validator.validString(email)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterEmail();
    }
    if (!email.contains("@")) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterEmail();
    }
    return email;
  }

  public String enterPhone() {
    System.out.print(" ENTER NUMBER PHONE \n \uD83D\uDC49 ");
    String number = scanner.next();
    if (!Validator.validNumber(number)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterPhone();
    }
    return number;
  }

  public String enterStatus() {
    System.out.print(" ENTER STATUS \n \uD83D\uDC49 ");
    System.out.print(" EXAMPLES  \uD83D\uDC49 available, pending, sold \n \uD83D\uDC49 ");
    String status = scanner.next();
    if (!Validator.validString(status)
        | !status.equalsIgnoreCase("available")
            & !status.equalsIgnoreCase("pending")
            & !status.equalsIgnoreCase("sold")) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterStatus();
    }
    return status;
  }

  public Category createCategory() {
    System.out.print(" ❗ Attention! ❗\n ❗ CREATING CATEGORY ❗\n \uD83D\uDC49 ");
    final Category category = new Category();
    category.setId(Long.valueOf(enterCategoryId()));
    category.setName(enterCategoryName());
    return category;
  }

  private String enterCategoryId() {
    System.out.print(" ENTER CATEGORY-ID \n \uD83D\uDC49 ");
    id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterId();
    }
    return id;
  }

  private String enterCategoryName() {
    System.out.print(" ENTER CATEGORY-NAME \n \uD83D\uDC49 ");
    name = scanner.next();
    if (!Validator.validString(name)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterCategoryName();
    }
    return name;
  }

  private String enterTagId() {
    System.out.print(" ENTER TAG-ID \n \uD83D\uDC49 ");
    id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterTagId();
    }
    return id;
  }

  private String enterTagName() {
    System.out.print(" ENTER TAG-NAME \n \uD83D\uDC49 ");
    name = scanner.next();
    if (!Validator.validString(name)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterTagName();
    }
    return name;
  }

  public List<Object> createTagList() {
    System.out.print(" ❗ Attention! ❗\n ❗ CREATING TAGS-LIST ❗\n \uD83D\uDC49 ");
    tagList.add(createTag());
    return tagList;
  }

  private Tag createTag() {
    Tag tag = new Tag();
    tag.setId(Long.valueOf(enterTagId()));
    tag.setName(enterTagName());
    //    String yesNo = yesNo();
    if (Validator.validString(yesNo()) & yesNo().equalsIgnoreCase("yes")) {
      tagList.add(tag);
      return createTag();
    }
    if (Validator.validString(yesNo()) & yesNo().equalsIgnoreCase("no")) {
      return tag;
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      yesNo();
    }
    return tag;
  }

  private String yesNo() {
    System.out.print(
        " CREATE ANOTHER TAG ? \n \uD83D\uDC49 YES \n \uD83D\uDC49 NO \n \uD83D\uDC49 ");
    return scanner.next();
  }

  public List<Object> createListImages() {
    System.out.print(" ❗ Attention! ❗\n ❗ CREATING IMAGES-LIST ❗\n \uD83D\uDC49 ");
    //    String image = pathToImage();
    imagesList.add(pathToImage());
    //    String addImageOrNo = addImageOrNo();
    if (Validator.validString(addImageOrNo()) & addImageOrNo().equalsIgnoreCase("yes")) {
      return createListImages();
    }
    return imagesList;
  }

  private String pathToImage() {
    System.out.print(
        " Please, enter the path to the file \n EXAMPLE \uD83D\uDC49 /User/DESKTOP/logo.png \n \uD83D\uDC49 ");
    return scanner.next();
  }

  private String addImageOrNo() {
    System.out.print(" ADD PHOTO ? \n \uD83D\uDC49 YES \n \uD83D\uDC49 NO \n \uD83D\uDC49 ");
    return scanner.next();
  }

  public String enterPetId() {
    System.out.print(" ENTER PET-ID \n \uD83D\uDC49 ");
    String petId = scanner.next();
    if (!Validator.validNumber(petId)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterPetId();
    }
    return petId;
  }

  public String enterQuantity() {
    System.out.print(" ENTER QUANTITY \n \uD83D\uDC49 ");
    String quantity = scanner.next();
    if (!Validator.validNumber(quantity)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterQuantity();
    }
    return quantity;
  }

  public String enterStatusStore() {
    System.out.print(" ENTER STATUS \n \uD83D\uDC49 ");
    System.out.print(" EXAMPLES  \uD83D\uDC49 placed, approved, delivered \n \uD83D\uDC49 ");
    String status = scanner.next();
    if (!Validator.validString(status)
        | !status.equalsIgnoreCase("placed")
            & !status.equalsIgnoreCase("approved")
            & !status.equalsIgnoreCase("delivered")) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterStatus();
    }
    return status;
  }

  @Override
  public void start() {}

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
