package ma.gymmanager.Service;

import java.util.List;

import ma.gymmanager.domaine.AdherentVo;

public interface IAdherentService {
    void save(AdherentVo adherentVo);
    void add(AdherentVo adherentVo);
    List<AdherentVo> findAll();
    void delete(int id);
    AdherentVo getById(int id);
}