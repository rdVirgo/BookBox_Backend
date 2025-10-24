package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservationId implements Serializable {

    private int boiteId;
    private int utilisateurId;

    public ReservationId(){}

    public ReservationId(int boiteId,int utilisateurId){
        this.boiteId = boiteId;
        this.utilisateurId = utilisateurId;
    }

    @Override
    public boolean equals(Object object){

        if (this == object) return true;

        if (object == null || this.getClass() != object.getClass()) return false;

        ReservationId id = (ReservationId) object;

        return Objects.equals(boiteId,id.boiteId) && Objects.equals(utilisateurId,id.utilisateurId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(boiteId, utilisateurId);
    }

}
