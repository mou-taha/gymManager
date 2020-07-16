package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.model.Sport;

public interface ISportService {
    void save(SportVo sportVo);
    void delete(int id);
    List<SportVo> getAllSports();
    SportVo getById(int id);
    Page<Sport> findAll(int pageId,int size);
}