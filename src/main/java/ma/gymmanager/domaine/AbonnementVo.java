package ma.gymmanager.domaine;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonnementVo {
    
    private Integer id;
    private LocalDate dateDebut;
    private String dateDebutString;
    private int nbMois;
    private LocalDate datePaiment;
  
    private AdherentVo adherent;
 
    private SportVo sport;

    public AbonnementVo(LocalDate dateDebut, int nbMois, LocalDate datePaiment, AdherentVo adherent, SportVo sport) {
        this.dateDebut = dateDebut;
        this.nbMois = nbMois;
        this.datePaiment = datePaiment;
        this.adherent = adherent;
        this.sport = sport;
    }

    
}