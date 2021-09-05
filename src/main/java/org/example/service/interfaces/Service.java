package org.example.service.interfaces;

public interface Service<T, ID> {

  Integer delete(ID id);

  T findById(ID id);
}
