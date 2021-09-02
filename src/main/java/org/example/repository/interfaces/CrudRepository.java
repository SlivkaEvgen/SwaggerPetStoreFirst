package org.example.repository.interfaces;

public interface CrudRepository<T> {

  void create(T t);

  void update(T t);
}
