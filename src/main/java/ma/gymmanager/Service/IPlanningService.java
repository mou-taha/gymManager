package ma.gymmanager.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.gymmanager.domaine.PlanningVo;
import ma.gymmanager.model.Planning;

public interface IPlanningService {
    void save(PlanningVo planningVo);
    void add(PlanningVo groupeVo);
    List<PlanningVo> findAll();
    void delete(int id) ;
    PlanningVo getById(int id);
    Page<Planning> findAll(int pageId, int size);
}