package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Sport;

public interface SportRepositry extends JpaRepository <Sport,Integer>{
    
}