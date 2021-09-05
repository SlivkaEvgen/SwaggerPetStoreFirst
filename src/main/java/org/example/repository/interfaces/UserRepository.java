package org.example.repository.interfaces;

import java.util.List;

public interface UserRepository<T,ID> extends CrudRepository<T, ID> {

  Integer loginUser(ID id, String password);

  Integer logOutUser();

  Integer create(T t);

  Integer get(ID id);

  Integer createListUsers(List<T> usersList);

  Integer update(T t, ID id);

  Integer delete(ID id);
}
