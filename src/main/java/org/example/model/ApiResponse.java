package org.example.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class ApiResponse implements Serializable {

  private static final long serialVersionUID = 88249378887777L;

  Integer code;
  String type;
  String message;
}
