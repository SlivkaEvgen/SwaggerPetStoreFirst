package org.example.repository.interfaces;

import org.example.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User> {

  Integer loginUser(String username, String password);

  Integer logOutUser();

  Integer create(User user);

  Integer get(String userName);

  Integer createListUsers(List<User> usersList);

  Integer update(User user);

  Integer delete(String userName);
}
