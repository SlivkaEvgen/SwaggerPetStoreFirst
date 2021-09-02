package org.example.repository.interfaces;

import org.example.model.Pet;
import java.io.File;

public interface PetRepository extends CrudRepository<Pet> {

  void uploadImage(File file, Integer petId);

  void delete(Integer petId);

  void findPetByStatus(String status);

  void create(Pet pet);

  void update(Pet pet);

  void get(Integer petId);

  void updatePut(Pet pet);
}
