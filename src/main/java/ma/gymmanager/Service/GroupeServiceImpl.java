package ma.gymmanager.Service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.EntraineurRepository;
import ma.gymmanager.dao.GroupeRepository;
import ma.gymmanager.dao.SportRepositry;
import ma.gymmanager.domaine.EntraineurConverter;
import ma.gymmanager.domaine.GroupeConverter;
import ma.gymmanager.domaine.GroupeVo;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.exceptions.GroupeHadAdherentException;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Groupe;
import ma.gymmanager.model.Sport;

@Service
@Data
@Transactional
public class GroupeServiceImpl implements IGroupeService {

    @Autowired
    GroupeRepository groupeDao;

    @Autowired
    EntraineurRepository entraineurDao;

    @Autowired
    SportRepositry sportDao;

    @Override
    public void save(GroupeVo groupeVo) {
        Groupe g = GroupeConverter.ToBo(groupeVo);
        Entraineur entraineurPersist = entraineurDao.getOne(groupeVo.getEntraineur().getId());
        Sport sportPersist = sportDao.getOne(groupeVo.getSport().getId());
        g.setEntraineur(entraineurPersist);
        g.setSport(sportPersist);
        groupeDao.save(g);
    }

    @Override
    public List<GroupeVo> findAll() {
        return GroupeConverter.toListVo(groupeDao.findAll());
    }

    @Override
    public void delete(int id) {
   //     Groupe g = groupeDao.getOne(id);
       // if (g.getAdherents().size() > 0)
         //   throw new GroupeHadAdherentException("Echec de suppression du groupe "+g.getNom()+" : des adherent son adheré au groupe.");
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

    @Override
    public void add(GroupeVo groupeVo) {
        // TODO Auto-generated method stub
    }

}