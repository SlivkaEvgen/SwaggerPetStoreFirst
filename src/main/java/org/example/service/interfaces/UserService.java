package org.example.service.interfaces;

import org.example.model.User;
import java.util.List;

public interface UserService {

  Integer createNewUser(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone);

  Integer logOutUser();

  Integer loginUser(String username, String password);

  Integer getUser(String userName);

  Integer createListUsers(List<User> usersList);

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
