package org.example.service.interfaces;

import org.example.model.Category;
import org.example.model.Tag;

import java.io.File;
import java.util.List;

public interface PetService<T, ID> extends Service<T, ID> {

  String findPetByStatus(String status);

  T create(
      ID id, String name, String status, Category category, List<String> images, List<Tag> tagList);

  ID uploadImage(File file, Long petId);

  ID update(ID id, String name, String status);

  T updatePut(
      ID id, String name, String status, Category category, List<String> images, List<Tag> tagList);

  ID delete(ID petId);

  T findById(ID petId);
}
