package ma.gymmanager.domaine;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gymmanager.model.GroupeSanguin;

@Data
@NoArgsConstructor
public class AdherentVo {
    private Integer id;
    private String nom;
    private String prenom;
    private Date dateN;
    private char sexe;
    private String tel;
    private String email;
    private String ville;
    private String adresse;
    private String PCANom;
    private String PCATel;
    private String maladie;
    private String cin;
    private GroupeSanguin Groupe_Sanguin;

    public AdherentVo(String nom,String prenom, Date dateN, char sexe, String tel, String email, String ville, String adresse,
            String pCANom, String pCATel, String maladie, String cin, GroupeSanguin groupe_Sanguin) {
        this.nom = nom;
        this.prenom=prenom;
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
        Groupe_Sanguin = groupe_Sanguin;
    }

}