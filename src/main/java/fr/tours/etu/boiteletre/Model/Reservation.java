package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;


@Entity
@Table(name="reservation")
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

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Boite getBoite() {
        return boite;
    }

    public void setBoite(Boite boite) {
        this.boite = boite;
    }

    public Utilisateur getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Utilisateur utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
