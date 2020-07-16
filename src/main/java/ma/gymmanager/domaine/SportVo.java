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
    private double prixSeance;
    private double prixMois;
    private int minAge;
    private  List<EntraineurVo> entraineur;

    public SportVo( List<EntraineurVo> entraineur,String description, double prixSeance, double prixMois, int minAge,String nom) {
        this.description = description;
        this.prixSeance = prixSeance;
        this.prixMois = prixMois;
        this.minAge = minAge;
        this.sport=nom;
        this.entraineur=entraineur;
    }
}