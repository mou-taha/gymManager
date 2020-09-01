package ma.gymmanager.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.Time;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="plannings")
@Data
@NoArgsConstructor
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String jourSemaine;
    private Time heureDebut;
    private Time heurFin;
    private String Commentaire;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_groupe",referencedColumnName = "id")
    private Groupe groupe;
}