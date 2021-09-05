package org.example.repository.interfaces;

import java.io.File;

public interface PetRepository<T, ID> extends CrudRepository<T, ID> {

  Integer uploadImage(File file, Integer petId);

  Integer delete(ID id);

  Integer findPetByStatus(String status);

  T create(T t);

  Integer update(T t, ID id);

  T get(ID id);

  Integer updatePut(T t);
}
