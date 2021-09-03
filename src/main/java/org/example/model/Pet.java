package org.example.model;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class Pet implements Serializable {

  private static final long serialVersionUID = 5888882349777L;

  private Integer id;
  private String name;
  private Category category;
  private List<String> photoUrls;
  private String status; // available, pending, sold
  private List<Tag> tags;
}
