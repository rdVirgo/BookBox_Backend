/**
 * A class used to create objects representing API errors.
 * It contains an error message and an associated HTTP status code.
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
package fr.tours.etu.boiteletre.Configuration;
// imports
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiException extends RuntimeException {
    /**
     * The error message describing what went wrong.
     */
    private String message;

    /**
     * The HTTP status associated with the error.
     */
    private HttpStatus status;
}
