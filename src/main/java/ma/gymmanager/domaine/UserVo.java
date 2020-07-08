package ma.gymmanager.domaine;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Integer id;
    private String password;
    private String username;
    private List<RoleVo> roles;

    public UserVo(String password, String username, List<RoleVo> roles) {
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    

}
