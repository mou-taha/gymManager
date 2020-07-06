package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.gymmanager.model.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent,Integer> {
    
}