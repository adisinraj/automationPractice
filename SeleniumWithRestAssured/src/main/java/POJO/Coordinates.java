package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {
    private String latitude;
    private String longitude;

    // Getters and Setters
}
