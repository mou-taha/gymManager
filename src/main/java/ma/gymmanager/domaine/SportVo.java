package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gymmanager.model.Entraineur;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportVo {
    
    private Integer id;
    private String sport;
    private String description;
    private double prixMois;
    private int minAge;

    public SportVo(String description, double prixMois, int minAge,String nom) {
        this.description = description;
        this.prixMois = prixMois;
        this.minAge = minAge;
        this.sport=nom;
    }
}