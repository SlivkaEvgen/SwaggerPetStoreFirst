package org.example.service.interfaces;

import org.example.model.User;
import java.util.List;

public interface UserService {

  void createNewUser(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone);

  void logOutUser();

  void loginUser(String username, String password);

  void getUser(String userName);

  void createListUsers(List<User> usersList);

  void update(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone);

  void delete(String userName);
}
