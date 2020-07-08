package ma.gymmanager.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo {
    private int id;
    private String nom;

    public RoleVo(String nom) {
        this.nom = nom;
    }
}
