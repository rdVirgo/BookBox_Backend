/**
 * A controllerAdivce class to handle all the errors that may the user encounter.
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
package fr.tours.etu.boiteletre.Configuration;
// imports
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // error 400

    /**
     *
     * @param ex : IllegalArgumenyException object
     * @return  a message to signal a bad request 400
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>("Invalid Syntax, Bad request" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // All Errors

    /**
     *
     * @param ex : ApiException object for all the other Errors.
     * @return an Error message and type of the error
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleApiException(ApiException ex) {
        return new ResponseEntity<>( ex.getMessage(), ex.getStatus());
    }


}
