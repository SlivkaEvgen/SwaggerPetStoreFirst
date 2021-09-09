package org.example.repository.interfaces;

public interface CrudRepository<T, ID> {

  // T get(ID id);

  T create(T t);

  //  ID delete(ID id);
}
