package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepositoryImpl;
import org.example.service.interfaces.UserService;
import java.util.List;

public class UserServiceImpl implements UserService<User, Long> {

  private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
  private static UserServiceImpl userService;

  public static UserServiceImpl getUserService() {
    if (userService == null) {
      userService = new UserServiceImpl();
    }
    return userService;
  }

  @Override
  public Long loginUser(String username, String password) {
    return userRepository.loginUser(username, password);
  }

  @Override
  public Long logOutUser() {
    return userRepository.logOutUser();
  }

  @Override
  public User getByUserName(String userName) {
    return userRepository.getByUserName(userName);
  }

  @Override
  public Long createListUsers(List<User> usersList) {
    return userRepository.createListUsers(usersList);
  }

  @Override
  public Long createNewUser(
      Long id,
      String userName,
      String firstName,
      String lastName,
      String password,
      String email,
      String phone) {
    User user = new User();
    user.setId(id);
    user.setUserName(userName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUserStatus(200);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(phone);
    return userRepository.create(user);
  }

  @Override
  public Long update(Long id, String userName, Integer status) {
    User user = new User();
    user.setId(id);
    user.setUserName(userName);
    user.setUserStatus(status);
    return userRepository.update(user, userName);
  }

  @Override
  public Long delete(String userName) {
    return userRepository.delete(userName);
  }
}
