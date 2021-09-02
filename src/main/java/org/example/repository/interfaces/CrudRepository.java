package org.example.repository.interfaces;

public interface CrudRepository<T> {

  Integer create(T t);

  Integer update(T t);
}
