package org.example.repository.interfaces;

public interface CrudRepository<T, ID> {

  Integer create(T t);

  Integer update(T t, ID id);

  Integer delete(ID id);

  Integer get(ID id);
}
