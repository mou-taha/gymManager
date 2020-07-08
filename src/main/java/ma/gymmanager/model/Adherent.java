package ma.gymmanager.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "adherents")
@Data
@NoArgsConstructor
public class Adherent {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
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
    private String GroupeSanguin;
    @Transient
    private GroupeSanguin Groupe_Sanguin;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="fk_user",referencedColumnName = "id")
    private User user;
}