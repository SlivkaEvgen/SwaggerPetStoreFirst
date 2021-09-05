package org.example.repository.interfaces;

public interface CrudRepository<T> {

  T create(T t);

  Integer update(T t, String userName);
}
