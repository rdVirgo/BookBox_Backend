package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.Model.Boite;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.Utilisateur;
import fr.tours.etu.boiteletre.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository ReservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        ReservationRepository = reservationRepository;
    }

    public Reservation getReservationById(int id) {
        return ReservationRepository.getById(id);
    }
    public List<Reservation> getAllReservations() {
        return ReservationRepository.findAll();
    }
    public Reservation createReservation(Reservation reservation) {
        return ReservationRepository.save(reservation);
    }
    public Reservation createReservation(Boite boite, Utilisateur utilisateur) {
        Reservation reservation = new Reservation(boite,utilisateur);
        return ReservationRepository.save(reservation);
    }
    public void deleteReservation(int id) {
        Reservation reservation = ReservationRepository.getById(id);
        ReservationRepository.delete(reservation);
    }
    public Reservation updateReservation(Reservation reservation , int id) {
        return ReservationRepository.findById(id).map(user ->{
            user.setUtilisateurId(reservation.getUtilisateurId());
            user.setBoite(reservation.getBoite());
            return ReservationRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }


}
