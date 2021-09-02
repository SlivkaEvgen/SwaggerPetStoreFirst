package org.example.controller.pet;

import org.example.controller.CommandImpl;
import org.example.controller.ControllerImpl;

import java.util.Scanner;

public class PetControllerImpl {
    Scanner scanner = new ControllerImpl().getScanner();

    public void startPet() {
        System.out.print("\n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
        String next = scanner.next();
        if (next.equalsIgnoreCase("back")){
            new CommandImpl().start();
        }
        if (next.equalsIgnoreCase("stop")) {
            stop();
        }
    }

    public void stop() {
        System.exit(0);
        scanner.close();
    }
}
