package org.example.controller.user;

import org.example.controller.Controller;

public interface UserController extends Controller {

  void logIn();

  void logOut();

  void get();

  void create();

  void update();

  void delete();
}
