package org.example.repository.interfaces;

import org.example.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User> {

  Integer loginUser(String username, String password);

  Integer logOutUser();

  User create(User user);

  Integer get(String userName);

  Integer createListUsers(List<User> usersList);

  Integer update(User user,String userName);

  Integer delete(String userName);
}
