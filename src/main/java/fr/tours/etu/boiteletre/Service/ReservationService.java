package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationDTO;
import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationIdAndDTO;
import fr.tours.etu.boiteletre.Exception.ApiException;
import fr.tours.etu.boiteletre.MappStruct.ReservationMapper;
import fr.tours.etu.boiteletre.Model.Box;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Repository.BoxRepository;
import fr.tours.etu.boiteletre.Repository.ReservationRepository;
import fr.tours.etu.boiteletre.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *  A  service Class for the Reservation Class
 * @author Mamadou COULIBALY & rdvirgo
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class ReservationService {
    /**
     * reservationRepository
     */
    private final ReservationRepository reservationRepository;

    /**
     * Box repository to manage action about box entity.
     */
    private final BoxRepository boxRepository;

    /**
     * User repository to manage action about user entity.
     */
    private final UserRepository userRepository;

    /**
     * reservationMapper
     */
    private final ReservationMapper reservationMapper;

    /**
     * create a reservation
     * @param reservationDTO : ReservationDTO
     * @return ReservationDTO
     */
    public Reservation createReservation(ReservationDTO reservationDTO) {

        Reservation reservation = reservationMapper.dtoToReservation(reservationDTO);

        Box box = boxRepository.findById(reservation.getReservationId().getBoxId())
                .orElseThrow(()->new ApiException("The box with the id : " +
                        reservation.getReservationId().getBoxId() + " not found !", HttpStatus.NOT_FOUND));

        User user = userRepository.findById(reservation.getReservationId().getUserId())
                .orElseThrow(()-> new ApiException("The user with the id : " +
                        reservation.getReservationId().getUserId() + " not found!",HttpStatus.NOT_FOUND));

        reservation.setBox(box);
        reservation.setUser(user);

        return reservationRepository.save(reservation);

    }

    /**
     * read all the list of the reservations from the database
     * @return a list of reservationDTO
     */
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * read the reservation of the given id
     * @param reservationId : int the id of the reservation to read
     * @return ReservationDTO
     */
    public Reservation getReservationById(ReservationId reservationId) {

        return reservationRepository.findById(reservationId).orElseThrow(
                ()-> new IllegalArgumentException("Reservation id : " + reservationId + " not found!"));
    }

    /**
     * update a reservation
     * @param reservationIdAndDTO the object containing the new information of the reservation
     * @return reservationDTO with information updated
     */
    public Reservation updateReservation(ReservationIdAndDTO reservationIdAndDTO){

        Reservation reservation = reservationRepository.findById(reservationIdAndDTO.getReservationId()).orElseThrow(()-> new IllegalArgumentException("Reservation id : " + reservationIdAndDTO.getReservationDTO() + " not found. So cannot be updated!"));

        Box box = boxRepository.findById(reservationIdAndDTO.getReservationDTO().getReservationId().getBoxId())
                .orElseThrow(()->new ApiException("The box with the id : " +
                        reservationIdAndDTO.getReservationDTO().getReservationId().getBoxId() + " not found !", HttpStatus.NOT_FOUND));

        User user = userRepository.findById(reservationIdAndDTO.getReservationDTO().getReservationId().getUserId())
                .orElseThrow(()-> new ApiException("The user with the id : " +
                        reservationIdAndDTO.getReservationDTO().getReservationId().getUserId() + " not found!",HttpStatus.NOT_FOUND));

        reservationRepository.deleteById(reservationIdAndDTO.getReservationId());

        reservation.setBox(box);
        reservation.setUser(user);
        reservation.setReservationNb(reservationIdAndDTO.getReservationDTO().getReservationNb());
        reservation.setReservationId(reservationIdAndDTO.getReservationDTO().getReservationId());

        return reservationRepository.save(reservation);


    }

    /**
     * delete the reservation corresponding to the given ReservationId
     * @param reservationId : ReservationId
     */
    public void deleteReservation(ReservationId reservationId) {
        if (!reservationRepository.existsById(reservationId)){
            throw new IllegalArgumentException("Reservation id : " + reservationId + " not found. So cannot be deleted!");
        }
        reservationRepository.deleteById(reservationId);
    }




}
