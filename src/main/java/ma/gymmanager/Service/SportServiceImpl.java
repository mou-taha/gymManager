package ma.gymmanager.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.EntraineurRepository;
import ma.gymmanager.dao.SportRepositry;
import ma.gymmanager.domaine.EntraineurConverter;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Sport;

@Service
@Transactional
@Data
public class SportServiceImpl implements ISportService {

    @Autowired
    SportRepositry sportDao;

    @Autowired
    EntraineurRepository entraineurDao;

    @Override
    public void save(SportVo sportVo) {
        List<Entraineur> listenPersiste=new ArrayList<>();
        for(Entraineur en :EntraineurConverter.toListBo( sportVo.getEntraineur()))
        {
            Entraineur EntraineurVoPersiste =entraineurDao.getOne(en.getId());
            listenPersiste.add(EntraineurVoPersiste);
        }
        sportVo.setEntraineur(EntraineurConverter.toListVo( listenPersiste));
        sportDao.save(SportConverter.toBo(sportVo));
    }

    @Override
    public void delete(int id) {
        Sport s=sportDao.getOne(id);
       // s.setEntraineurs(null);
        //sportDao.save(s);
        sportDao.deleteById(id);
    }

    @Override
    public List<SportVo> getAllSports() {
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