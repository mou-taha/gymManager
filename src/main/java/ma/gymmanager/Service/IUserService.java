package ma.gymmanager.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.gymmanager.domaine.RoleVo;
import ma.gymmanager.domaine.UserVo;

public interface IUserService extends UserDetailsService{
    void add(UserVo user);
    void update(UserVo user);
    void save(RoleVo role);
    void delete(Long id);
    List<UserVo> getAlluUsers();
    List<RoleVo> getAllRoles();
    RoleVo getRoleByName(String role);
}