package org.example.repository.interfaces;

import org.example.model.Pet;
import java.io.File;
import java.util.List;

public interface PetRepository extends CrudRepository<Pet> {

  Integer uploadImage(File file, Integer petId);

  Integer delete(Integer petId);

 Integer findPetByStatus(String status);

  Pet create(Pet pet);

  Integer update(Pet pet, String petName);

  Pet get(Integer petId);

  Integer updatePut(Pet pet);
}
