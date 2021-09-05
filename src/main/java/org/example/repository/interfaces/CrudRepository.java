package org.example.repository.interfaces;

public interface CrudRepository<T, ID> {

  //T create(T t);

 // Integer update(T t, ID id);

  Integer delete(ID id);

  T get(ID id);
}
