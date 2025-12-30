package POJO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
/**
 *Jackson (used by RestAssured internally) requires public getters and setters to map JSON fields to Java objects.
 *  If your POJO class doesn't have them, Jackson can't populate the fields — and throws an UnrecognizedPropertyException
 */
public class UserResponse {
    private List<Result> results;
    private Info info;

    public Info getInfo() {
        return info;
    }

    public List<Result> getResults() {
        return results;
    }
// Getters and Setters
}