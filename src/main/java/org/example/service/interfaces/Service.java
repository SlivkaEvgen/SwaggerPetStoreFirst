package org.example.service.interfaces;

public interface Service<T, ID> {

  T findById(ID id);
}
