package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationDTO;
import fr.tours.etu.boiteletre.Model.Reservation;
import org.mapstruct.Mapper;
/**
 *  A  mapper for the reservation entity
 * to convert a reservation to a Reservation DTO
 * convert a reservationDTO to a Reservation
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface ReservationMapper {
    /**
     * convert a reservation to a DTO
     * @param reservation
     * @return reservationDTO
     */
    ReservationDTO reservationToDto(Reservation reservation);

    /**
     * convert a reservationDTO into a Reservation
     * @param reservationDTO
     * @return a reservation
     */
    Reservation dtoToReservation(ReservationDTO reservationDTO);
}
