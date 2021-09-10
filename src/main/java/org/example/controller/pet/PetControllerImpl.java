package org.example.controller.pet;

import lombok.NoArgsConstructor;
import org.example.config.ScannerConsole;
import org.example.controller.ControllerImpl;
import org.example.controller.interfaces.PetController;

import java.util.Scanner;

@NoArgsConstructor
public class PetControllerImpl implements PetController {

  private static PetControllerImpl petController;
  private final Scanner scanner = ScannerConsole.getInstance();

  public static PetControllerImpl getPetController() {
    if (petController == null) {
      petController = new PetControllerImpl();
    }
    return petController;
  }

  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 UPLOAD-IMAGE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String next = scanner.next();
    if (next.equalsIgnoreCase("get")) {
      get();
      start();
    }
    if (next.equalsIgnoreCase("create")) {
      create();
      start();
    }
    if (next.equalsIgnoreCase("update")) {
      update();
      start();
    }
    if (next.equalsIgnoreCase("upload-image")) {
      uploadImage();
      start();
    }
    if (next.equalsIgnoreCase("delete")) {
      delete();
      start();
    }
    if (next.equalsIgnoreCase("back")) {
      new ControllerImpl().start();
    }
    if (next.equalsIgnoreCase("stop")) {
      stop();
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  public void stop() {
    System.exit(0);
  }

  @Override
  public void get() {
    PetGetImpl.getPetGetCommand().start();
  }

  @Override
  public void create() {
    PetCreateImpl.getPetCreateCommand().start();
  }

  @Override
  public void update() {
    PetUpdateImpl.getPetUpdateCommand().start();
  }

  @Override
  public void delete() {
    PetDeleteImpl.getPetDeleteCommand().start();
  }

  @Override
  public void uploadImage() {
    PetUpLoadImageImpl.getPetUpLoadImageCommand().start();
  }
}
