package org.example.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 62345888887777L;

    Integer id;
    Integer petId;
    Integer quantity;
    String shipDate;
    String status;
    Boolean complete;
}
