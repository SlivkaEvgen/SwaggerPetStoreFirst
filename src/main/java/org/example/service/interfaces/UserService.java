package org.example.service.interfaces;

import org.example.model.User;

import java.util.List;

public interface UserService<T, ID> extends Service<T, ID> {

  Long loginUser(String username, String password);

  Long logOutUser();

  User getByName(String userName);

  Long createListUsers(List<User> usersList);

  User createNewUser(
      Long id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone);

  Long update(Long id, String userName, Integer status);

  Long delete(String userName);
}
