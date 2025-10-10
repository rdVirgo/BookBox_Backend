package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import  lombok.Data;


@Entity
@Table(name="reservation")
@Data
public class Reservation {

    @Column(nullable = false)
    private int reservationId;

    @Id
    @OneToOne
    @JoinColumn(name="boiteId")
    private Boite boite;

    @Id
    @ManyToOne
    @JoinColumn(name="utilisateurId")
    private Utilisateur utilisateurId;


    public Reservation() {}
    public Reservation(Boite boite, Utilisateur utilisateurId) {
        this.reservationId = reservationId;
        this.boite = boite;
        this.utilisateurId = utilisateurId;
    }

}
