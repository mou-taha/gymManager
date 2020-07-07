package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.Planning;

public interface PlanningRepository extends JpaRepository <Planning,Integer>{
    
}