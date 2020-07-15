package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.GroupeVo;
import ma.gymmanager.model.Groupe;

public interface IGroupeService {
    void save(GroupeVo groupeVo);
    void add(GroupeVo groupeVo);
    List<GroupeVo> findAll();
    void delete(int id);
    GroupeVo getById(int id);
    Page<Groupe> findAll(int pageId, int size);
}