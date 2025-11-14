/**
 * A controllerAdvice class to "catch" all errors that the user may encounter.
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
package fr.tours.etu.boiteletre.Exception;
// imports
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // error 400

    /**
     * a bad request 400
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
   // errors that spring catch by itself :

    /**
     * catch a 404 error  : didn't find an entity
     * @param ex
     * @return
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>( "didn't find the entity "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * the database refuses the operation (insert a double ...)
     * a 409 error
     * @param ex
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("Database constraint violated.", HttpStatus.CONFLICT);
    }

    /**
     * validation failed ( for example a mandatory field is left empty).
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>( ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
