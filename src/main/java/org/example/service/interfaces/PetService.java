package org.example.service.interfaces;

import org.example.model.Category;
import org.example.model.Pet;
import java.io.File;
import java.util.List;

public interface PetService<T, ID> extends Service<T, ID> {

  Integer findPetByStatus(String status);

  Pet create(
      Integer id,
      String name,
      String status,
      Category category,
      List<Object> images,
      List<Object> tagList);

  Integer uploadImage(File file, Integer petId);

  Integer update(
      Integer id,
      String name,
      String status,
      Category category,
      List<Object> images,
      List<Object> tagList);

  Integer updatePut(
      Integer id,
      String name,
      String status,
      Category category,
      List<Object> images,
      List<Object> tagList);

  Integer delete(Integer petId);

  Pet findById(Integer petId);
}
