package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.controller.Controller;
import org.example.controller.EnterCommands;
import org.example.model.Order;
import org.example.service.StoreServiceImpl;

@NoArgsConstructor
public class StoreCreateCommandImpl implements Controller {

  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final StoreServiceImpl storeService = StoreServiceImpl.getStoreService();
  private static StoreCreateCommandImpl storeCreateCommand;

  public static StoreCreateCommandImpl getStoreCreateCommand() {
    if (storeCreateCommand == null) {
      storeCreateCommand = new StoreCreateCommandImpl();
    }
    return storeCreateCommand;
  }

  @Override
  public void start() {
    Order order =
        storeService.placeAnOrderForAPet(
            enterCommands.enterId(),
            enterCommands.enterPetId(),
            Integer.valueOf(enterCommands.enterQuantity()),
            enterCommands.enterStatusStore());
    if (order.getId() != null) {
      System.out.println(" ✅ Successfully");
      System.out.println(order);
    } else {
      System.out.print("\n      ⚠️ Wrong ⚠️ \n \uD83D\uDCAC Please, enter again \n");
      start();
    }
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
