package ma.gymmanager.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.model.Entraineur;

public interface IEntraineurService {
    
    int save(EntraineurVo entraineurVo);
    int add(EntraineurVo entraineurVo);
    List<EntraineurVo> findAll();
    void delete(int id);
    EntraineurVo getById(int id);
    Page<Entraineur> findAll(int pageId, int size);
    List<EntraineurVo> getEntraineurBySport(int sportId);
    
}