package ma.gymmanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ma.gymmanager.dao.AbonnementRepository;
import ma.gymmanager.dao.AdherentRepository;
import ma.gymmanager.dao.EntraineurRepository;
import ma.gymmanager.dao.SportRepositry;
import ma.gymmanager.domaine.AbonnementConverter;
import ma.gymmanager.domaine.AbonnementVo;
import ma.gymmanager.model.Abonnement;
import ma.gymmanager.model.Adherent;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Sport;

public class AbonnementServiceImpl implements IAbonnementService {
    @Autowired
    SportRepositry sportDao;

    @Autowired 
    AdherentRepository adherentDao;

    @Autowired
    AbonnementRepository abonnementDao;

    @Override
    public void save(AbonnementVo abonnementVo) {
        Abonnement abonnement=AbonnementConverter.toBo(abonnementVo);
        Sport sportPersist=sportDao.getOne(abonnement.getId());
        Adherent adherentPersist=adherentDao.getOne(abonnement.getId());
        abonnement.setAdherent(adherentPersist);
        abonnement.setSport(sportPersist);
        abonnementDao.save(abonnement);
    }

    @Override
    public List<AbonnementVo> findAll() {
        return AbonnementConverter.toListVo(abonnementDao.findAll());
    }

    @Override
    public void delete(int id) {
        abonnementDao.deleteById(id);
    }

    @Override
    public AbonnementVo getById(int id) {
        return AbonnementConverter.toVo(abonnementDao.getOne(id));
    }

    @Override
    public Page<Abonnement> findAll(int pageId, int size) {
        return abonnementDao.findAll(PageRequest.of(pageId, size));
    }
    
}