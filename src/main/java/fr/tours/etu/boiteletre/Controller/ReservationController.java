package fr.tours.etu.boiteletre.Controller;


import fr.tours.etu.boiteletre.Model.Boite;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.Utilisateur;
import fr.tours.etu.boiteletre.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Reservations")

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
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }
    @PostMapping
    public Reservation createReservation(Boite boite, Utilisateur utilisateur) {
        return reservationService.createReservation(boite, utilisateur);
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return  reservationService.getReservationById(id);}

    @PutMapping
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
       reservationService.deleteReservation(id);
    }
}
