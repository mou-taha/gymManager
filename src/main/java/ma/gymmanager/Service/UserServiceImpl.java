package ma.gymmanager.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.Data;
import ma.gymmanager.dao.RoleRepository;
import ma.gymmanager.dao.UserRepository;
import ma.gymmanager.domaine.RoleConverter;
import ma.gymmanager.domaine.RoleVo;
import ma.gymmanager.domaine.UserConverter;
import ma.gymmanager.domaine.UserVo;
import ma.gymmanager.model.Role;
import ma.gymmanager.model.User;

@Service("userService")
@Data
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        boolean enabled = true;
        boolean accountNotExpired = true;
        boolean credentialsNotExpired = true;
        boolean accoutnNotLocked = true;
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled,
                accountNotExpired, credentialsNotExpired, accoutnNotLocked, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
        for (Role r : roles) {
            springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getNom()));
        }
        return springSecurityAuthorities;
    }

    @Override
    public void add(UserVo user) {
        User u=UserConverter.toBo(user);
        u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : u.getRoles()) {
            Role userRole = roleRepository.findByNom(role.getNom()).get(0);
            rolesPersist.add(userRole);
        }
        u.setRoles(rolesPersist);
        userRepository.save(u);
    }

    @Override
    public void update(UserVo user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void save(RoleVo role) {
        roleRepository.save(RoleConverter.toBo(role));
        
    }

    @Override
    public void delete(Long userId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<UserVo> getAlluUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoleVo> getAllRoles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoleVo getRoleByName(String nom) {
        return RoleConverter.toVo(roleRepository.findByNom(nom).get(0));
    }

    @Override
    public RoleVo getById(int id) {
        return RoleConverter.toVo(roleRepository.getOne(id));
    }


}