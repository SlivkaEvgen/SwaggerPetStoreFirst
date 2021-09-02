package org.example.model;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class Pet implements Serializable {

    private static final long serialVersionUID = 5888882349777L;

    Integer id;
    String name;
    Category category;
    String[] photoUrls;
    String status;  //available, pending, sold
    List<Tag> tags;
}
