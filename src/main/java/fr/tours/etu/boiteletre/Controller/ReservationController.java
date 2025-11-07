package fr.tours.etu.boiteletre.Controller;


import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationDTO;
import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationIdAndDTO;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @GetMapping
    public List<ReservationDTO> getAllReservation() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/id")
    public ReservationDTO getReservationById(@RequestBody ReservationId id) {

        try{
            return reservationService.getReservationById(id);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage() + " : " + ex.getCause());
        }
        return null;
    }

    @PutMapping("/id")
    public ReservationDTO updateReservation(@RequestBody ReservationIdAndDTO reservationIdAndDTO) {
        try{
            return reservationService.updateReservation(reservationIdAndDTO);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @DeleteMapping("/id")
    public void deleteReservation(@RequestBody ReservationId id) {
        try{
            reservationService.deleteReservation(id);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage());
        }
    }
}
