package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private Coordinates coordinates;
    private Timezone timezone;

    // Getters and Setters
}