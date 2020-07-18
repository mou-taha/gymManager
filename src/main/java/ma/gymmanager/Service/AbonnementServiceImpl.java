package ma.gymmanager.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.AbonnementRepository;
import ma.gymmanager.dao.AdherentRepository;
import ma.gymmanager.dao.EntraineurRepository;
import ma.gymmanager.dao.SportRepositry;
import ma.gymmanager.domaine.AbonnementConverter;
import ma.gymmanager.domaine.AbonnementVo;
import ma.gymmanager.exceptions.AdherentAgeException;
import ma.gymmanager.model.Abonnement;
import ma.gymmanager.model.Adherent;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Sport;

@Service
@Data
@Transactional
public class AbonnementServiceImpl implements IAbonnementService {
    @Autowired
    SportRepositry sportDao;

    @Autowired
    AdherentRepository adherentDao;

    @Autowired
    AbonnementRepository abonnementDao;

    @Override
    public void save(AbonnementVo abonnementVo) throws AdherentAgeException {
        abonnementVo.setDateDebut(LocalDate.parse(abonnementVo.getDateDebutString()));
        Abonnement abonnement = AbonnementConverter.toBo(abonnementVo);
        abonnement.setDatePaiment(LocalDate.now());
        Sport sportPersist = sportDao.getOne(abonnementVo.getSport().getId());
        Adherent adherentPersist = adherentDao.getOne(abonnementVo.getAdherent().getId());
        abonnement.setAdherent(adherentPersist);
        if (LocalDate.now().getYear()-adherentPersist.getDateN().getYear() < sportPersist.getMinAge())
            throw new AdherentAgeException("echec d'ajout de l'adherent, n'a pas un age minimum requis pour abonné a ce sport (minimum age c'est : "+sportPersist.getMinAge()+")");
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
    public Page<Abonnement> findAll(int pageId, int size, String filter) {
        List<Abonnement> l = abonnementDao.findAll();
        List<Abonnement> listf = new ArrayList<>();
        if (filter != null)
            for (Abonnement a : l) {
                if (filter.equals("valid") && a.getDateDebut().plusMonths(a.getNbMois()).isAfter(LocalDate.now()))
                    listf.add(a);
                else if (filter.equals("invalid")
                        && !a.getDateDebut().plusMonths(a.getNbMois()).isAfter(LocalDate.now()))
                    listf.add(a);
            }
        else
            listf = l;
        Page<Abonnement> page = new PageImpl<>(listf, PageRequest.of(pageId, size), listf.size());
        return page;
    }
}