package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements Serializable {

  private static final long serialVersionUID = 5888882349777L;

  private Integer id;
  private String name,status;
  private Category category;
  private List<String> photoUrls;
  private List<Tag> tags;
}
