package org.example.service.interfaces;

import org.example.model.Category;
import org.example.model.Tag;
import java.io.File;
import java.util.List;

public interface PetService {

  void uploadImage(File file, Integer petId);

  void findPetByStatus(String status);

  void create(
      Integer id,
      String name,
      String status,
      Category category,
      String[] images,
      List<Tag> tagList);

  void update(
      Integer id,
      String name,
      String status,
      Category category,
      String[] images,
      List<Tag> tagList);

  void get(Integer petId);

  void updatePut(
      Integer id,
      String name,
      String status,
      Category category,
      String[] images,
      List<Tag> tagList);

  void delete(Integer petId);
}
