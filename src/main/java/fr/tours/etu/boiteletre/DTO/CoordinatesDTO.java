package fr.tours.etu.boiteletre.DTO;

import lombok.Data;

import java.util.Objects;

@Data
public class CoordinatesDTO {
    private String latitude;
    private String longitude;

    public CoordinatesDTO(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return latitude + " " + longitude;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        CoordinatesDTO coordinatesDTO = (CoordinatesDTO) object;

        return Objects.equals(latitude,coordinatesDTO.latitude) && Objects.equals(longitude,coordinatesDTO.longitude);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(latitude) + Objects.hashCode(longitude);
    }
}
