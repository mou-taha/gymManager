package ma.gymmanager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "entraineurs")
@Data
@NoArgsConstructor
public class Entraineur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    private char sexe;
    private String cinN;
    private String tel;
    private String email;
    private String ville; 
    private String adresse;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="entraineur_sport",joinColumns = @JoinColumn(name= "id_entraineur"),inverseJoinColumns = @JoinColumn(name ="id_sport"))
    private List<Sport> sports;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user",referencedColumnName = "id")
    User user;
}
