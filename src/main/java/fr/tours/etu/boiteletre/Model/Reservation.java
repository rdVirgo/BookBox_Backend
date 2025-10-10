package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import  lombok.Data;


@Entity
@Table(name="reservation")
@Data
public class Reservation {

    @Column(nullable = false)
    private int reservationNb;

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
        this.boite = boite;
        this.utilisateurId = utilisateurId;
    }

}
