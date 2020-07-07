package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Abonnement;

public interface AbonnementRepository  extends JpaRepository<Abonnement,Integer>{
    
}