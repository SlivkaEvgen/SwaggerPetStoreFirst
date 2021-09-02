package org.example.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Tag implements Serializable {

    private static final long serialVersionUID = 9382619309373L;

    Integer id;
    String name;
}
