package ma.gymmanager.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ma.gymmanager.dao.AdherentRepository;
import ma.gymmanager.dao.RoleRepository;
import ma.gymmanager.dao.UserRepository;
import ma.gymmanager.domaine.AdherentConverter;
import ma.gymmanager.domaine.AdherentVo;
import ma.gymmanager.model.Adherent;
import ma.gymmanager.model.Role;
import ma.gymmanager.model.User;

@Service
@Data
@Transactional
public class AdherentServiceImpl implements IAdherentService {

    @Autowired
    AdherentRepository adherentDao;

    @Autowired
    UserRepository userDao;

    @Autowired
    JavaMailSender MailSender;

    @Autowired
    RoleRepository roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AdherentVo adherentVo) {
        adherentDao.save(AdherentConverter.toBo(adherentVo));
    }

    @Override
    public List<AdherentVo> findAll() {
        return AdherentConverter.toListVo(adherentDao.findAll());
    }

    @Override
    public void delete(int id) {
        adherentDao.delete(adherentDao.getOne(id));
    }

    @Override
    public void add(AdherentVo adherentVo) {
        SimpleMailMessage message = new SimpleMailMessage();
        // add default user to adherent
        User user = new User();
        user.setRoles(Arrays.asList(roleDao.findByNom("ADHERENT").get(0)));
        user.setUsername(adherentVo.getNom() + "_" + adherentVo.getPrenom());
        user.setPassword(bCryptPasswordEncoder.encode(adherentVo.getCin()));
        userDao.save(user);
        adherentVo.setUser(user);
        adherentDao.save(AdherentConverter.toBo(adherentVo));
        message.setTo(adherentVo.getEmail());
        message.setText("votre  nom d'utilisateur c'est " + adherentVo.getNom() + "_" + adherentVo.getPrenom()
                + ".le mot de passe c'est :" +adherentVo.getCin());
        message.setSubject("Notification");
        MailSender.send(message);
    }

    @Override
    public AdherentVo getById(int id) {
        return AdherentConverter.toVo(adherentDao.getOne(id));
    }

}