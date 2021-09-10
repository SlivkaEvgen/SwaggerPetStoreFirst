package org.example.controller.store;

import lombok.NoArgsConstructor;
import org.example.controller.interfaces.Controller;
import org.example.controller.EnterCommands;
import org.example.model.Order;
import org.example.service.StoreServiceImpl;

@NoArgsConstructor
public class StoreCreateImpl implements Controller {

  private final EnterCommands enterCommands = EnterCommands.getEnterCommands();
  private final StoreServiceImpl storeService = StoreServiceImpl.getStoreService();
  private static StoreCreateImpl storeCreateCommand;

  public static StoreCreateImpl getStoreCreateCommand() {
    if (storeCreateCommand == null) {
      storeCreateCommand = new StoreCreateImpl();
    }
    return storeCreateCommand;
  }

  private void create(){
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
  public void start() {
    create();
  }

  @Override
  public void stop() {
    System.exit(0);
  }
}
