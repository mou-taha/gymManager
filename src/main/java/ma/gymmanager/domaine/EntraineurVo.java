package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gymmanager.model.Sport;
import ma.gymmanager.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntraineurVo {
    private Integer id;
    private String nom;
    private String prenom;
    private char sexe;
    private String cinN;
    private String tel;
    private String email;
    private String ville; 
    private String adresse;
    private User user;
    private List<SportVo> sports=new ArrayList<SportVo>();

    public EntraineurVo(String nom, String prenom, char sexe, String cinN, String tel, String email, String ville,
            String adresse, List<SportVo> sports) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.cinN = cinN;
        this.tel = tel;
        this.email = email;
        this.ville = ville;
        this.adresse = adresse;
        this.sports = sports;
    }
}