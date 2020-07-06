package ma.gymmanager.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private GroupeSanguin GroupeSanguin;
}