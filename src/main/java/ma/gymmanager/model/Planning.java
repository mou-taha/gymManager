package ma.gymmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Time;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="plannings")
@Data
@NoArgsConstructor
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private JourS jourS;
    private Time heureDebut;
    private Time heurFin;
    private String Commentaire;
}