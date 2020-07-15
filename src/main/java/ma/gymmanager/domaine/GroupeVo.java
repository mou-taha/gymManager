package ma.gymmanager.domaine;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeVo {
    private Integer id;
    private String nom;
    private int nbplace;
    private EntraineurVo entraineur;
    private SportVo sport;
    private List<AdherentVo> adherents;
    
}