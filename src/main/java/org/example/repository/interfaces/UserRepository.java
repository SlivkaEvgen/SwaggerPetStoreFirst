package org.example.repository.interfaces;

import java.util.List;

public interface UserRepository<T,ID> extends CrudRepository<T, ID> {

  Integer loginUser(ID id, String password);

  Integer logOutUser();

  T create(T t);

  T get(ID id);

  Integer createListUsers(List<T> usersList);

  Integer update(T t, ID id);

  Integer delete(ID id);
}
