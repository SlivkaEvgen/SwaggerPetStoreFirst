package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepositoryImpl;
import org.example.service.interfaces.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

  private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

  @Override
  public void createNewUser(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone) {
    User user = new User();
    user.setId(id);
    user.setUsername(userName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUserStatus(status);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(phone);
    userRepository.create(user);
  }

  @Override
  public void logOutUser() {
    userRepository.logOutUser();
  }

  @Override
  public void loginUser(String username, String password) {
    userRepository.loginUser(username, password);
  }

  @Override
  public void getUser(String userName) {
    userRepository.get(userName);
  }

  @Override
  public void createListUsers(List<User> usersList) {
    userRepository.createListUsers(usersList);
  }

  @Override
  public void update(
      Integer id,
      String userName,
      String firstName,
      String lastName,
      Integer status,
      String password,
      String email,
      String phone) {
    User user = new User();
    user.setId(id);
    user.setUsername(userName);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUserStatus(status);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(phone);
    userRepository.update(user);
  }

  @Override
  public void delete(String userName) {
    userRepository.delete(userName);
  }
}
