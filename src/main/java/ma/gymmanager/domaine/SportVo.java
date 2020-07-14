package ma.gymmanager.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gymmanager.model.Entraineur;

@Data
@NoArgsConstructor
public class SportVo {
    private Integer id;
    private String nom;
    private String description;
    private double prixSeance;
    private double prixMois;
    private int minAge;
    private EntraineurVo entraineur;

    public SportVo(EntraineurVo entraineur,String description, double prixSeance, double prixMois, int minAge,String nom) {
        this.description = description;
        this.prixSeance = prixSeance;
        this.prixMois = prixMois;
        this.minAge = minAge;
        this.nom=nom;
        this.entraineur=entraineur;
    }
}