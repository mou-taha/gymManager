package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.GroupeVo;
import ma.gymmanager.model.Groupe;

public interface IGroupeService {
    void save(GroupeVo adherentVo);
    void add(GroupeVo adherentVo);
    List<GroupeVo> findAll();
    void delete(int id);
    GroupeVo getById(int id);
    Page<Groupe> findAll(int pageId, int size);
}