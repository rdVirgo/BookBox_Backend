package fr.tours.etu.boiteletre.Controller;


import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationDTO;
import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationIdAndDTO;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  A controller class for the Reservation entity.
 * It contains  the crud operations for the user side.
 *
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@RestController
@CrossOrigin("*")
@RequestMapping("api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    /**
     * a parameter for the Reservation Service object
     */
    private final ReservationService reservationService;

    /**
     * Creates a new Reservation.
     *
     * @param reservationDTO a DTO object containing information about the reservation to be created.
     * @return A ReservationDTO containing details of the created reservation.
     */
    @PostMapping
    public Reservation createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    /**
     * Retrieves all the existing reservation in the database.
     * @return a list of the reservation  found in the database
     */
    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservations();
    }

    /**
     * Retrieves the Reservation object that corresponds for  the given parameter ID
     * @param id the id of the reservation
     * @return A ReservationDTO containing the specific reservation with its details
     */
    @GetMapping("/id")
    public Reservation getReservationById(@RequestBody ReservationId id) {
            return reservationService.getReservationById(id);
    }

    /**
     * Update a specific reservation selected by its ID
     * @param reservationIdAndDTO the new coordinate containing the updated box information.
     * @return a CoordinatesDTO containing the coordinate updated with the new information
     */
    @PutMapping("/id")
    public Reservation updateReservation(@RequestBody ReservationIdAndDTO reservationIdAndDTO) {
            return reservationService.updateReservation(reservationIdAndDTO);
    }

    /**
     * Delete a reservation corresponding to the given ID ( from the reservationid class containing the user id and boxId)
     * @param id the id parameter of the RESERVATION to delete
     */
    @DeleteMapping("/id")
    public void deleteReservation(@RequestBody ReservationId id) {
            reservationService.deleteReservation(id);
    }
}
