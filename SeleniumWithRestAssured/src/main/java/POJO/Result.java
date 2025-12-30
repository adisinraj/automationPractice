package POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
/**
 *Jackson (used by RestAssured internally) requires public getters and setters to map JSON fields to Java objects.
 *  If your POJO class doesn't have them, Jackson can't populate the fields — and throws an UnrecognizedPropertyException
 */
@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * I have commented the last "nat" which is present in the coming response,
 * using above annotation, it ignores the leftover mapping of Json to Java object.
 * If we dont use it, then we get UnrecognizedPropertyException
 */
public class Result {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private Dob dob;
    private Registered registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
  //  private String nat;

    // Getters and Setters
}
