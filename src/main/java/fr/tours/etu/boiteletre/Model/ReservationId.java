package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservationId implements Serializable {

    private int boxId;
    private int userId;

    public ReservationId(){}

    public ReservationId(int boxId, int userId){
        this.boxId = boxId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object){

        if (this == object) return true;

        if (object == null || this.getClass() != object.getClass()) return false;

        ReservationId id = (ReservationId) object;

        return Objects.equals(boxId,id.boxId) && Objects.equals(userId,id.userId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(boxId, userId);
    }

}
