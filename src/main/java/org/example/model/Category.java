package org.example.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Category implements Serializable {

  private static final long serialVersionUID = 7835463788887777L;

  private Integer id;
  private String name;
}
