package fr.tours.etu.boiteletre.DTO;

import lombok.Data;

import java.util.Objects;

@Data
public class BoxDTO {
    private String name;
    private int quantity;
    private String description;

    public BoxDTO(String name, int quantity, String description) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    @Override
    public String toString(){
        return name + " " + quantity + " " + description;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        BoxDTO boxDTO = (BoxDTO) object;

        return Objects.equals(name,boxDTO.name) && Objects.equals(quantity,boxDTO.quantity) &&
                Objects.equals(description,boxDTO.description);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(name) + Objects.hashCode(quantity) + Objects.hashCode(description);
    }


}
