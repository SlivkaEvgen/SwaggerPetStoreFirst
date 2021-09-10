package org.example.request.interfaces;

public interface StoreRepository<T, ID> extends CrudRepository<T, ID> {

  void getInventory();

  T getById(ID id);

  T create(T t);

  ID delete(ID id);
}
