package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationDTO;
import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationIdAndDTO;
import fr.tours.etu.boiteletre.MappStruct.ReservationMapper;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 *  A  service Class for the Reservation Class
 * @author Coulibaly Mamadou & Radia MERABTENE
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
     * reservationMapper
     */
    private final ReservationMapper reservationMapper;

    /**
     * create a reservation
     * @param reservationDTO
     * @return ReservationDTO
     */
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {

        Reservation reservation = reservationMapper.dtoToReservation(reservationDTO);

        return reservationMapper.reservationToDto(reservationRepository.save(reservation));
    }

    /**
     * read all the list of the reservations from the database
     * @return a list of reservationDTO
     */
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservationsList = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOList = new ArrayList<>();

        if (!reservationsList.isEmpty()){
            for (Reservation r : reservationsList){
                reservationDTOList.add(reservationMapper.reservationToDto(r));
            }
        }
        return reservationDTOList;
    }

    /**
     * read the reservation of the given id
     * @param reservationId : int the id of the reservation to read
     * @return ReservationDTO
     */
    public ReservationDTO getReservationById(ReservationId reservationId) {

        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(()-> new IllegalArgumentException("Reservation id : " + reservationId + " not found!"));

        return reservationMapper.reservationToDto(reservation);
    }

    /**
     * update a reservation
     * @param reservationIdAndDTO the object containing the new information of the reservation
     * @return reservationDTO with information updated
     */
    public ReservationDTO updateReservation(ReservationIdAndDTO reservationIdAndDTO){

        Reservation reservation = reservationRepository.findById(reservationIdAndDTO.getReservationId()).orElseThrow(()-> new IllegalArgumentException("Reservation id : " + reservationIdAndDTO.getReservationDTO() + " not found. So cannot be updated!"));

        reservationRepository.delete(reservation);

        Reservation saveReservation = reservationMapper.dtoToReservation(reservationIdAndDTO.getReservationDTO());

        return reservationMapper.reservationToDto(reservationRepository.save(saveReservation));

    }

    /**
     * delete the reservation corresponding to the given ReservationId
     * @param reservationId
     */
    public void deleteReservation(ReservationId reservationId) {
        if (!reservationRepository.existsById(reservationId)){
            throw new IllegalArgumentException("Reservation id : " + reservationId + " not found. So cannot be deleted!");
        }
        reservationRepository.deleteById(reservationId);
    }




}
