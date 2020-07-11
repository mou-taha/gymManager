package ma.gymmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sports")
@Data
@NoArgsConstructor
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String description;
    private double prixSeance;
    private double prixMois;
    private int minAge;
}