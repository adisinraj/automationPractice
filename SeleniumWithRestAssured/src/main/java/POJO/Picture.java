package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Picture {
    private String large;
    private String medium;
    private String thumbnail;

    // Getters and Setters
}