package ma.gymmanager.dao;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository <Role,Integer>{
    
}