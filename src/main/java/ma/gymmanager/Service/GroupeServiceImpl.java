package ma.gymmanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.GroupeRepository;
import ma.gymmanager.domaine.GroupeConverter;
import ma.gymmanager.domaine.GroupeVo;
import ma.gymmanager.model.Groupe;

@Service
@Data
@Transactional
public class GroupeServiceImpl implements IGroupeService {

    @Autowired
    GroupeRepository groupeDao;


    @Override
    public void save(GroupeVo groupeVo) {
        Groupe g=GroupeConverter.ToBo(groupeVo);
        groupeDao.save(g);
    }

    @Override
    public void add(GroupeVo adherentVo) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<GroupeVo> findAll() {
        return GroupeConverter.toListVo( groupeDao.findAll());
    }

    @Override
    public void delete(int id) {
        groupeDao.deleteById(id);
    }

    @Override
    public GroupeVo getById(int id) {
        return GroupeConverter.ToVo(groupeDao.getOne(id));
    }

    @Override
    public Page<Groupe> findAll(int pageId, int size) {
        return groupeDao.findAll(PageRequest.of(pageId, size));
    }
    
}