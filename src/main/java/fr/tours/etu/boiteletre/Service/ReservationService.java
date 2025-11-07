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

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {

        Reservation reservation = reservationMapper.dtoToReservation(reservationDTO);

        return reservationMapper.reservationToDto(reservationRepository.save(reservation));
    }

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

    public ReservationDTO getReservationById(ReservationId reservationId) {

        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(()-> new IllegalArgumentException("Reservation id : " + reservationId + " not found!"));

        return reservationMapper.reservationToDto(reservation);
    }

    public ReservationDTO updateReservation(ReservationIdAndDTO reservationIdAndDTO){

        Reservation reservation = reservationRepository.findById(reservationIdAndDTO.getReservationId()).orElseThrow(()-> new IllegalArgumentException("Reservation id : " + reservationIdAndDTO.getReservationDTO() + " not found. So cannot be updated!"));

        reservationRepository.delete(reservation);

        Reservation saveReservation = reservationMapper.dtoToReservation(reservationIdAndDTO.getReservationDTO());

        return reservationMapper.reservationToDto(reservationRepository.save(saveReservation));

    }

    public void deleteReservation(ReservationId reservationId) {
        if (!reservationRepository.existsById(reservationId)){
            throw new IllegalArgumentException("Reservation id : " + reservationId + " not found. So cannot be deleted!");
        }
        reservationRepository.deleteById(reservationId);
    }




}
