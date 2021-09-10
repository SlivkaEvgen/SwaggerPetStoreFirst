package org.example.service.interfaces;

import java.util.List;

public interface UserService<T, ID> {

  ID loginUser(String username, String password);

  ID logOutUser();

  T getByUserName(String userName);

  ID createListUsers(List<T> usersList);

  ID createNewUser(
      ID id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone);

  ID update(ID id, String userName, Integer status);

  ID delete(String userName);
}
