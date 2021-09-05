package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.model.Category;
import org.example.model.Pet;
import org.example.model.Tag;
import org.example.service.PetServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// done 50/50
public class PetCreateCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();
  private final List<Object> tagList = new ArrayList<>();
  private final List<Object> imagesList = new ArrayList<>();

  private void create() {
    String id = enterId();
    String name = enterName();
    String status = enterStatus();
    Category category = createCategory();
    List<Object> images = createListImages();
    List<Object> tagList = createTagList();
    Pet pet =
        new PetServiceImpl().create(Integer.valueOf(id), name, status, category, images, tagList);
    System.out.println(pet);
    if (pet.getId() != 0) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
    }
  }

  private String enterId() {
    System.out.print(" ENTER ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterId();
    }
    return id;
  }

  private String enterName() {
    System.out.print(" ENTER NAME \n \uD83D\uDC49 ");
    String name = scanner.next();
    if (!Validator.validString(name)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterName();
    }
    return name;
  }

  private String enterStatus() {
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

  private Category createCategory() {
    System.out.print(" ❗ Attention! ❗\n ❗ CREATING CATEGORY ❗\n \uD83D\uDC49 ");
    String id = enterCategoryId();
    String name = enterCategoryName();
    Category category = new Category();
    category.setId(Long.valueOf(id));
    category.setName(name);
    return category;
  }

  private String enterCategoryId() {
    System.out.print(" ENTER CATEGORY-ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterId();
    }
    return id;
  }

  private String enterCategoryName() {
    System.out.print(" ENTER CATEGORY-NAME \n \uD83D\uDC49 ");
    String name = scanner.next();
    if (!Validator.validString(name)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterName();
    }
    return name;
  }

  private List<Object> createTagList() {
    System.out.print(" ❗ Attention! ❗\n ❗ CREATING TAGS-LIST ❗\n \uD83D\uDC49 ");
    tagList.add(createTag());
    return tagList;
  }

  private Tag createTag() {
    Tag tag = new Tag();
    String id = enterTagId();
    String name = enterTagName();
    tag.setId(Long.valueOf(id));
    tag.setName(name);
    String yesNo = yesNo();
    if (Validator.validString(yesNo) & yesNo.equalsIgnoreCase("yes")) {
      tagList.add(tag);
      return createTag();
    }
    if (Validator.validString(yesNo) & yesNo.equalsIgnoreCase("no")) {
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

  private String enterTagId() {
    System.out.print(" ENTER TAG-ID \n \uD83D\uDC49 ");
    String id = scanner.next();
    if (!Validator.validNumber(id)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterTagId();
    }
    return id;
  }

  private String enterTagName() {
    System.out.print(" ENTER TAG-NAME \n \uD83D\uDC49 ");
    String name = scanner.next();
    if (!Validator.validString(name)) {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      return enterTagName();
    }
    return name;
  }

  private List<Object> createListImages() {
    System.out.print(" ❗ Attention! ❗\n ❗ CREATING IMAGES-LIST ❗\n \uD83D\uDC49 ");
    String image = pathToImage();
    imagesList.add(image);
    String addImageOrNo = addImageOrNo();
    if (Validator.validString(addImageOrNo) & addImageOrNo.equalsIgnoreCase("yes")) {
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

  @Override
  public void start() {
    create();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
