package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="box")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Box {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boxId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column
    private String description;
    
    @OneToOne
    @JoinColumn(name="coordinatesId")
    private Coordinates coordinates;


    public Box(String name, int quantity, String description, int coordinates_id) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;

    }


}
