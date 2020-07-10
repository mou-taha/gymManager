package ma.gymmanager.domaine;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gymmanager.model.User;

@Data
@NoArgsConstructor
public class AdherentVo {
    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateN;
    private char sexe;
    private String tel;
    private String email;
    private String ville;
    private String adresse;
    private String PCANom;
    private String PCATel;
    private String maladie;
    private String GroupeSanguin;
    private String cin;
    private String dateNString;
    private User user;

    public AdherentVo(String nom, String prenom, LocalDate dateN, char sexe, String tel, String email, String ville,
            String adresse, String pCANom, String pCATel, String maladie, String cin, String dateNString, User user) {
        this.user = user;
        this.nom = nom;
        this.prenom = prenom;
        this.dateN = dateN;
        this.sexe = sexe;
        this.tel = tel;
        this.email = email;
        this.ville = ville;
        this.adresse = adresse;
        PCANom = pCANom;
        PCATel = pCATel;
        this.maladie = maladie;
        this.cin = cin;
        this.dateNString = dateNString;
    }

}