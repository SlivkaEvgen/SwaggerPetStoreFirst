package org.example.service.interfaces;

import org.example.model.User;
import java.util.List;

public interface UserService<T, ID> extends Service<T, ID> {

  Integer logOutUser();

  Integer loginUser(String username, String password);

  Integer findById(String userName);

  Integer createListUsers(List<User> usersList);

  User createNewUser(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone);

  Integer update(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone);

  Integer delete(String userName);
}
