package fr.tours.etu.boiteletre.Controller;


import fr.tours.etu.boiteletre.Model.Boite;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Model.Utilisateur;
import fr.tours.etu.boiteletre.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public Reservation createReservation(@RequestParam int boiteId, @RequestParam int utilisateurId, @RequestParam int reservationNb) {
        return reservationService.createReservation(boiteId, utilisateurId, reservationNb);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable ReservationId id) {
        return  reservationService.getReservationById(id);}

    /*@PutMapping
    public Reservation updateReservation(@PathVariable ReservationId id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation, id);
    }*/

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable ReservationId id) {
       reservationService.deleteReservation(id);
    }
}
