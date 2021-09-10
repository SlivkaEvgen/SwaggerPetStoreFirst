package org.example.controller.pet;

import lombok.NoArgsConstructor;
import org.example.controller.interfaces.Controller;
import org.example.controller.EnterCommands;
import org.example.model.Pet;
import org.example.service.PetServiceImpl;

@NoArgsConstructor
public class PetCreateImpl implements Controller {

  private static PetCreateImpl petCreateCommand;
  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final PetServiceImpl petService = PetServiceImpl.getPetServiceImpl();

  public static PetCreateImpl getPetCreateCommand() {
    if (petCreateCommand == null) {
      petCreateCommand = new PetCreateImpl();
    }
    return petCreateCommand;
  }

  private void create() {
    Pet pet =
        petService.create(
            enterCommands.enterId(),
            enterCommands.enterName(),
            enterCommands.enterStatus(),
            enterCommands.createCategory(),
            enterCommands.createListImages(),
            enterCommands.createTagList());
    System.out.println(pet);
    if (pet.getId() != 0) {
      System.out.println(" ✅ Successfully");
    } else {
      System.out.print("\n      ⚠️ Something Wrong ⚠️ \n \uD83D\uDCAC Please, try again \n ");
    }
  }

  @Override
  public void start() {
    create();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
