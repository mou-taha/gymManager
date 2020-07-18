package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.AbonnementVo;
import ma.gymmanager.exceptions.AdherentAgeException;
import ma.gymmanager.model.Abonnement;

public interface IAbonnementService {
    void save(AbonnementVo abonnementVo) throws AdherentAgeException;
    List<AbonnementVo> findAll();
    void delete(int id);
    AbonnementVo getById(int id);
    Page<Abonnement> findAll(int pageId, int size,String filter);
}