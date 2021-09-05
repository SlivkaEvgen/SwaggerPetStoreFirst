package org.example.controller.pet;

import okhttp3.internal.http2.ConnectionShutdownException;
import org.example.config.ScannerConsole;
import org.example.controller.Controller;
import org.example.controller.Validator;
import org.example.service.PetServiceImpl;
import java.io.File;
import java.util.Scanner;
// done
public class PetUpLoadImageCommandImpl implements Controller {

  private final Scanner scanner = ScannerConsole.getInstance();

  private void upload() throws InterruptedException, ConnectionShutdownException {
    System.out.print(" ENTER PET-ID \n \uD83D\uDC49 ");
    String petId = scanner.next();
    if (Validator.validNumber(petId)) {
      System.out.print(
          " Please, enter the path to the file \n EXAMPLE \uD83D\uDC49 /User/DESKTOP/logo.png \n \uD83D\uDC49 ");
      String next = scanner.next();
      if (Validator.validString(next) & next.contains("png") | next.contains("jpg")) {
        Integer integer = new PetServiceImpl().uploadImage(new File(next), Integer.valueOf(petId));
        if (integer != null) {
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
  public void start() throws ConnectionShutdownException, InterruptedException {
    upload();
  }

  @Override
  public void stop() {
    System.exit(0);
    scanner.close();
  }
}
