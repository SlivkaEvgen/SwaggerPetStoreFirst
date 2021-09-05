package org.example.repository.interfaces;

public interface StoreRepository<T,ID> extends CrudRepository<T,ID>{

  Integer delete(ID id);

  T findById(ID id);

  Integer create(T t);

  Integer get(ID id);
}
