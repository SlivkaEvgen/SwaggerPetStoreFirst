package org.example.repository.interfaces;

import java.io.File;

public interface PetRepository<T, ID> extends CrudRepository<T, ID> {

  ID uploadImage(File file, ID petId);

  ID delete(ID id);

  String findPetByStatus(String status);

  T create(T t);

  ID update(ID id, String petName, String status);

  T getById(ID id);

  T updatePut(T t);
}
