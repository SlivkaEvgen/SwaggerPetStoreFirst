package org.example.controller.pet;

import org.example.controller.Controller;

public interface PetController extends Controller {

    void get();

    void create();

    void update();

    void delete();

    void uploadImage();
}
