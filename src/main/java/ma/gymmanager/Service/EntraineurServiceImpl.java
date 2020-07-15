package ma.gymmanager.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.EntraineurRepository;
import ma.gymmanager.dao.RoleRepository;
import ma.gymmanager.dao.SportRepositry;
import ma.gymmanager.dao.UserRepository;
import ma.gymmanager.domaine.EntraineurConverter;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Sport;
import ma.gymmanager.model.User;

@Service
@Data
@Transactional
public class EntraineurServiceImpl implements IEntraineurService {

    @Autowired
    EntraineurRepository entraineurDao;

    @Autowired
    SportRepositry sportDao;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    RoleRepository roleDao;

    @Autowired
    UserRepository userDao;

    @Autowired
    ISportService sportservice;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int save(EntraineurVo entraineurVo) {
        Entraineur en = EntraineurConverter.toBo(entraineurVo);
        List<Sport> sportPersist = new ArrayList<>();
        for (Sport s : en.getSports()) {
            sportPersist.add(sportDao.getOne(s.getId()));
        }
        en.setSports(sportPersist);
        entraineurVo = EntraineurConverter.toVo(entraineurDao.saveAndFlush(en));
        return entraineurVo.getId();
    }

    @Override
    public int add(EntraineurVo entraineurVo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Notification GYM MANAGER");
        // create default user
        User user = new User();
        user.setRoles(Arrays.asList(roleDao.findByNom("COACH").get(0)));
        user.setUsername(entraineurVo.getNom() + "_" + entraineurVo.getPrenom());
        user.setPassword(bCryptPasswordEncoder.encode(entraineurVo.getCinN()));
        userDao.save(user);
        entraineurVo.setUser(user);
        entraineurVo.setSports(new ArrayList<>());
        int id = save(entraineurVo);
        message.setTo(entraineurVo.getEmail());
        message.setText("votre  nom d'utilisateur c'est " + entraineurVo.getNom() + "_" + entraineurVo.getPrenom()
                + ".le mot de passe c'est :" + entraineurVo.getCinN());
        // mailSender.send(message);
        return id;
    }

    @Override
    public List<EntraineurVo> findAll() {
        return EntraineurConverter.toListVo(entraineurDao.findAll());
    }

    @Override
    public void delete(int id) {
        EntraineurVo entraineur = getById(id);
        // remove child
        entraineur.setUser(null);
        save(entraineur);
        for(SportVo s: entraineur.getSports()){
            s.setEntraineur(null);
            sportDao.save(SportConverter.toBo(s));
        }
        entraineurDao.delete(entraineurDao.getOne(id));
    }

    @Override
    public EntraineurVo getById(int id) {
        return EntraineurConverter.toVo(entraineurDao.getOne(id));
    }

    @Override
    public Page<Entraineur> findAll(int pageId, int size) {
        return entraineurDao.findAll(PageRequest.of(pageId, size));
    }

}