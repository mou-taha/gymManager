package ma.gymmanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import ma.gymmanager.dao.GroupeRepository;
import ma.gymmanager.domaine.GroupeConverter;
import ma.gymmanager.domaine.GroupeVo;
import ma.gymmanager.model.Groupe;

public class GroupeServiceImpl implements IGroupeService {

    @Autowired
    GroupeRepository groupeDao;

    @Override
    public void save(GroupeVo groupeVo) {
        Groupe gr=GroupeConverter.ToBo(groupeVo);

    }

    @Override
    public void add(GroupeVo adherentVo) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<GroupeVo> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public GroupeVo getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Groupe> findAll(int pageId, int size) {
        // TODO Auto-generated method stub
        return null;
    }
    
}