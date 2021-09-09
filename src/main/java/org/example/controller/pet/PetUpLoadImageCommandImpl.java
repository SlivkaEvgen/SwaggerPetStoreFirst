package org.example.controller.pet;

import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.service.PetServiceImpl;
import org.example.util.Validator;
import java.io.File;
import java.util.Scanner;

public class PetUpLoadImageCommandImpl implements Controller {

  private static PetUpLoadImageCommandImpl petUpLoadImageCommand;
  private final Scanner scanner = ScannerConsole.getInstance();
  private final PetServiceImpl petService = PetServiceImpl.getPetServiceImpl();

  public static PetUpLoadImageCommandImpl getPetUpLoadImageCommand() {
    if (petUpLoadImageCommand == null) {
      petUpLoadImageCommand = new PetUpLoadImageCommandImpl();
    }
    return petUpLoadImageCommand;
  }

  private void upload() {
    System.out.print(" ENTER PET-ID \n \uD83D\uDC49 ");
    String petId = scanner.next();
    if (Validator.validNumber(petId)) {
      System.out.print(
          " Please, enter the path to the file \n EXAMPLE \uD83D\uDC49 /User/DESKTOP/logo.png \n \uD83D\uDC49 ");
      String next = scanner.next();
      if (Validator.validString(next) & next.contains("/")
          && next.contains("png") | next.contains("jpg")) {
          Long integer = petService.uploadImage(new File(next), Long.valueOf(petId));
        if (integer == 200) {
          System.out.println(" ✅ Successfully");
        } else {
          System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
          upload();
        }
      } else {
        System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
        upload();
      }
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
      upload();
    }
  }

  @Override
  public void start() {
    upload();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
