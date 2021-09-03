package org.example.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {

  private static final long serialVersionUID = 239475831256347L;

  private Integer id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  private Integer userStatus;
}
