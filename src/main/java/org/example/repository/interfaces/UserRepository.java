package org.example.repository.interfaces;

import org.example.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User> {

  void loginUser(String username, String password);

  void logOutUser();

  void create(User user);

  void get(String userName);

  void createListUsers(List<User> usersList);

  void update(User user);

  void delete(String userName);
}
