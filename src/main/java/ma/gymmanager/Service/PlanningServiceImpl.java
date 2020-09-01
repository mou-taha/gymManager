package ma.gymmanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ma.gymmanager.dao.PlanningRepository;
import ma.gymmanager.domaine.PlanningConverter;
import ma.gymmanager.domaine.PlanningVo;
import ma.gymmanager.model.Planning;

@Service
public class PlanningServiceImpl implements IPlanningService {

    @Autowired
    PlanningRepository planningDao;

    @Override
    public void save(PlanningVo planningVo) {
        planningDao.save(PlanningConverter.toBo(planningVo));
    }

    @Override
    public void add(PlanningVo planningVo) {
        planningDao.save(PlanningConverter.toBo(planningVo));
    }

    @Override
    public List<PlanningVo> findAll() {
        return PlanningConverter.toListVo(planningDao.findAll());
    }

    @Override
    public void delete(int id) {
        planningDao.deleteById(id);
    }

    @Override
    public PlanningVo getById(int id) {
        return PlanningConverter.toVo(planningDao.getOne(id));
    }

    @Override
    public Page<Planning> findAll(int pageId, int size) {
        return planningDao.findAll(PageRequest.of(pageId ,size));
    }

}