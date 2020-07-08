package ma.gymmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.gymmanager.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String userName);
}