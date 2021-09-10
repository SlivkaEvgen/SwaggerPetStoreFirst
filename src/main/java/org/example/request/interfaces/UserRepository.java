package org.example.request.interfaces;

import java.util.List;

public interface UserRepository<T, ID> {

  ID loginUser(String userName, String password);

  ID logOutUser();

  ID create(T t);

  T getByUserName(String userName);

  ID createListUsers(List<T> usersList);

  ID update(T t, String userName);

  ID delete(String userName);
}
