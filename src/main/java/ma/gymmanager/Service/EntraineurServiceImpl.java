package ma.gymmanager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSender;

import ma.gymmanager.dao.EntraineurRepository;
import ma.gymmanager.domaine.EntraineurConverter;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.model.Entraineur;

public class EntraineurServiceImpl implements IEntraineurService {

    @Autowired
    EntraineurRepository entraineurDao;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void save(EntraineurVo entraineurVo) {
        entraineurDao.save(EntraineurConverter.toBo(entraineurVo));
    }

    @Override
    public void add(EntraineurVo entraineurVo) {

    }

    @Override
    public List<EntraineurVo> findAll() {
        return EntraineurConverter.toListVo(entraineurDao.findAll());
    }

    @Override
    public void delete(int id) {
        entraineurDao.delete(EntraineurConverter.toBo(getById(id)));

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