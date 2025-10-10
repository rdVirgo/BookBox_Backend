package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ReservationId.class)
public class Reservation {

    @Column(nullable = false)
    private int reservationNb;

    @Id
    private int boiteId;

    @Id
    private int utilisateurId;




    @OneToOne
    @JoinColumn(name="boiteId", insertable = false, updatable = false)
    private Boite boite;



    @ManyToOne
    @JoinColumn(name="utilisateurId", insertable = false, updatable = false)
    private Utilisateur utilisateur;



    public Reservation(Boite boiteId, Utilisateur utilisateurId) {
        this.boite = boiteId;
        this.utilisateur = utilisateurId;
    }

}
