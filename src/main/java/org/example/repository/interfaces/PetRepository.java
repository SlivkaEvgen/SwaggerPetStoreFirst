package org.example.repository.interfaces;

import java.io.File;

public interface PetRepository<T,ID> extends CrudRepository<T,ID> {

  Integer uploadImage(File file, Integer petId);

  Integer delete(ID id);

  Integer findPetByStatus(String status);

  Integer create(T t);

  Integer update(T t, ID id);

  Integer get(ID id);

  Integer updatePut(T t);
}
