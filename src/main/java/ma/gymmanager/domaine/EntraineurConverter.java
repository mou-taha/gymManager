package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Entraineur;

public class EntraineurConverter {


    public static Entraineur toBo(EntraineurVo vo) {
        Entraineur bo = new Entraineur();
        bo.setId(vo.getId());
        bo.setNom(vo.getNom());
        bo.setPrenom(vo.getPrenom());
        bo.setAdresse(vo.getAdresse());
        bo.setCinN(vo.getCinN());
        bo.setEmail(vo.getEmail());
        bo.setSexe(vo.getSexe());
        bo.setTel(vo.getTel());
        bo.setUser(vo.getUser());
        bo.setVille(bo.getVille());
        bo.setSports(vo.getSports());
        return bo;
    }

    public static EntraineurVo toVo(Entraineur bo) {
        EntraineurVo vo = new EntraineurVo();
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        vo.setPrenom(bo.getPrenom());
        vo.setAdresse(bo.getAdresse());
        vo.setCinN(bo.getCinN());
        vo.setEmail(bo.getEmail());
        vo.setSexe(bo.getSexe());
        vo.setTel(bo.getTel());
        vo.setUser(bo.getUser());
        vo.setVille(bo.getVille());
        vo.setSports(bo.getSports());
        return vo;
    }

    public static List<EntraineurVo> toListVo(List<Entraineur> listBo) {
        List<EntraineurVo> listVo = new ArrayList<>();
        for (Entraineur e : listBo)
            listVo.add(toVo(e));
        return listVo;
    }

    public static List<Entraineur> toListBo(List<EntraineurVo> listVo) {
        List<Entraineur> listBo = new ArrayList<>();
        for (EntraineurVo e : listVo)
            listBo.add(toBo(e));
        return listBo;
    }

}