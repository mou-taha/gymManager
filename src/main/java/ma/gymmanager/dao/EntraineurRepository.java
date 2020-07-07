package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Entraineur;

public interface EntraineurRepository extends JpaRepository<Entraineur,Integer>{
    
}