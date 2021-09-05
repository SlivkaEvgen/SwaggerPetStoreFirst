package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepositoryImpl;
import org.example.service.interfaces.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

  private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

  @Override
  public User createNewUser(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone) {
    User user = new User();
    user.setId(Long.valueOf(id));
    user.setUsername(userName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUserStatus(200L);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(phone);
    return userRepository.create(user);
  }

  @Override
  public Integer logOutUser() {
    return userRepository.logOutUser();
  }

  @Override
  public Integer loginUser(String username, String password) {
    return userRepository.loginUser(username, password);
  }

  @Override
  public Integer getUser(String userName) {
    return userRepository.get(userName);
  }

  @Override
  public Integer createListUsers(List<User> usersList) {
    return userRepository.createListUsers(usersList);
  }

  @Override
  public Integer update(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone) {
    User user = new User();
    user.setId(Long.valueOf(id));
    user.setUsername(userName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUserStatus(Long.valueOf(status));
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(phone);
    return userRepository.update(user, userName);
  }

  @Override
  public Integer delete(String userName) {
    return userRepository.delete(userName);
  }
}
