package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForReservation.ReservationDTO;
import fr.tours.etu.boiteletre.Model.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDTO reservationToDto(Reservation reservation);
    Reservation dtoToReservation(ReservationDTO reservationDTO);
}
