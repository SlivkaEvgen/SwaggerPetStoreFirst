package org.example.repository.interfaces;

public interface StoreRepository<T, ID> extends CrudRepository<T, ID> {
  void get();

  T findById(ID id);

  T create(T t);

  ID delete(ID id);
}
