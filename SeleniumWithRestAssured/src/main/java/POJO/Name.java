package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    private String title;
    private String first;
    private String last;

    // Getters and Setters
}
