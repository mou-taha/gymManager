package ma.gymmanager.domaine;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonnementVo {
    
    private Integer id;
    private Date dateDebut;
    private int nbMois;
    private Date datePaiment;
  
    private AdherentVo adherent;
 
    private SportVo sport;

    public AbonnementVo(Date dateDebut, int nbMois, Date datePaiment, AdherentVo adherent, SportVo sport) {
        this.dateDebut = dateDebut;
        this.nbMois = nbMois;
        this.datePaiment = datePaiment;
        this.adherent = adherent;
        this.sport = sport;
    }

    
}