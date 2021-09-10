package org.example.controller.store;

import org.example.controller.Controller;

public interface StoreController extends Controller {

  void get();

  void getInventory();

  void create();

  void update();

  void delete();
}
