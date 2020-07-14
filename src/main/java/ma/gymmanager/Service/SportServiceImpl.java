package ma.gymmanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.SportRepositry;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.model.Sport;

@Service
@Transactional
@Data
public class SportServiceImpl implements ISportService {

    @Autowired
    SportRepositry sportDao;

    @Override
    public void save(SportVo sportVo) {
        sportDao.save(SportConverter.toBo(sportVo));
    }

    @Override
    public void delete(int id) {
        sportDao.delete(SportConverter.toBo(getById(id)));
    }

    @Override
    public List<SportVo> findAll() {
        return SportConverter.toListVo(sportDao.findAll());
    }

    @Override
    public SportVo getById(int id) {
        return SportConverter.toVo(sportDao.getOne(id));
    }

    @Override
    public Page<Sport> findAll(int pageId, int size) {
        return sportDao.findAll(PageRequest.of(pageId ,size));
    }

}