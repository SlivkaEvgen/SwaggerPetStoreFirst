package org.example.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Order implements Serializable {

  private static final long serialVersionUID = 62345888887777L;

  private Integer id;
  private Integer petId;
  private Integer quantity;
  private String shipDate;
  private String status;
  private Boolean complete;
}
