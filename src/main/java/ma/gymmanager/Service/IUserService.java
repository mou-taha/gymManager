package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import ma.gymmanager.domaine.RoleVo;
import ma.gymmanager.domaine.UserVo;
import ma.gymmanager.model.User;

public interface IUserService extends UserDetailsService{
    void add(UserVo user);
    void save(UserVo user);
    void save(RoleVo role);
    void delete(int id);
    List<UserVo> getAlluUsers();
    List<RoleVo> getAllRoles();
    
    Page<User> getAlluUsers(int page,int size);
    Page<RoleVo> getAllRoles(int page,int size);
    RoleVo getRoleByName(String role);
    RoleVo getRoleById(int id); 
    UserVo getUserById(int id); 
}