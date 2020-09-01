package ma.gymmanager.domaine;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gymmanager.model.Groupe;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanningVo {
    private Integer id;
    private String jourSemaine;
    private Time heureDebut;
    private Time heurFin;
    private String Commentaire;
    private Groupe groupe;
    
}