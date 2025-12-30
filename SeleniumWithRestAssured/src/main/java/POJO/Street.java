package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Street {
    private int number;
    private String name;

    // Getters and Setters
}