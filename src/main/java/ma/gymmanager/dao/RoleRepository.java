package ma.gymmanager.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Role;

public interface RoleRepository  extends JpaRepository <Role,Integer>{
   List<Role> findByNom(String nom);
}