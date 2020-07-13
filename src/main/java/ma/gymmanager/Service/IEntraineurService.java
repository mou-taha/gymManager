package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.model.Entraineur;

public interface IEntraineurService {
    void save(EntraineurVo entraineurVo);
    void add(EntraineurVo entraineurVo);
    List<EntraineurVo> findAll();
    void delete(int id);
    EntraineurVo getById(int id);
    Page<Entraineur> findAll(int pageId, int size);
    
}