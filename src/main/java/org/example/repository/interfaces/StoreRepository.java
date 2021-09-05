package org.example.repository.interfaces;

public interface StoreRepository<T, ID> extends CrudRepository<T, ID> {

  Integer delete(ID id);

  T findById(ID id);

  T create(T t);

  T get(ID id);
}
