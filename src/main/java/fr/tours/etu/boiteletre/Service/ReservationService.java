package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository ReservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        ReservationRepository = reservationRepository;
    }

    public Reservation getReservationById(ReservationId ReservationId) {
        return ReservationRepository.getById(ReservationId);
    }

    public List<Reservation> getAllReservations() {
        return ReservationRepository.findAll();
    }

    public Reservation createReservation(int boxId, int userId, int reservationNb) {
        ReservationId reservationId = new ReservationId(boxId, userId);
        Reservation reservation = new Reservation(reservationId, reservationNb);
        return ReservationRepository.save(reservation);
    }

    public void deleteReservation(ReservationId ReservationId) {
        Reservation reservation = ReservationRepository.getById(ReservationId);
        ReservationRepository.delete(reservation);
    }




}
