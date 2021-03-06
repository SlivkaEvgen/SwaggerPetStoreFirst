package org.example.service.interfaces;

import org.example.model.User;

import java.util.List;

public interface UserService {

  Long loginUser(String username, String password);

  Long logOutUser();

  User getByUserName(String userName);

  Long createListUsers(List<User> usersList);

  Long createNewUser(
      Long id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone);

  Long update(
      Long id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone);

  Long delete(String userName);
}
