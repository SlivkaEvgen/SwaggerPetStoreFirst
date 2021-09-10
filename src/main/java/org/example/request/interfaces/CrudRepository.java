package org.example.request.interfaces;

public interface CrudRepository<T, ID> {

  T getById(ID id);

  T create(T t);

  ID delete(ID id);
}
