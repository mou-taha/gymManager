package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe,Integer> {
    
}