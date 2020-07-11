package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.AdherentVo;
import ma.gymmanager.model.Adherent;

public interface IAdherentService {
    void save(AdherentVo adherentVo);
    void add(AdherentVo adherentVo);
    List<AdherentVo> findAll();
    void delete(int id);
    AdherentVo getById(int id);
    Page<Adherent> findAll(int pageId, int size);
}