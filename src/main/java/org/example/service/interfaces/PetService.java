package org.example.service.interfaces;

import org.example.model.Category;
import org.example.model.Pet;
import org.example.model.Tag;

import java.io.File;
import java.util.List;

public interface PetService<T, ID> extends Service<T, ID> {

  String findPetByStatus(String status);

  Pet create(
      Long id,
      String name,
      String status,
      Category category,
      List<String> images,
      List<Tag> tagList);

    Long uploadImage(File file, Long petId);

    Long update(
      Long id,
      String name,
      String status);

    Long updatePut(
      Long id,
      String name,
      String status,
      Category category,
      List<String> images,
      List<Tag> tagList);

    Long delete(Long petId);

  Pet findById(Long petId);
}
