package ma.gymmanager.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Role;

public interface RoleRepository  extends JpaRepository <Role,Integer>{
    
}