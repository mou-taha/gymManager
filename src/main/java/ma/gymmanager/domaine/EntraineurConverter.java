package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Entraineur;

public class EntraineurConverter {

    public static Entraineur toBo(EntraineurVo vo) {
        if (vo == null)
			return null;
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
        bo.setVille(vo.getVille());
        bo.setSports(SportConverter.toListBo(vo.getSports()));
        return bo;
    }

    public static EntraineurVo toVo(Entraineur bo) {
        if (bo == null)
			return null;
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
        vo.setSports(SportConverter.toListVo(bo.getSports()));
        return vo;
    }

    public static List<EntraineurVo> toListVo(List<Entraineur> listBo) {
        if (listBo == null || listBo.isEmpty())
            return null;
        List<EntraineurVo> listVo = new ArrayList<>();
        for (Entraineur e : listBo)
            listVo.add(toVo(e));
        return listVo;
    }

    public static List<Entraineur> toListBo(List<EntraineurVo> listVo) {
        if (listVo == null || listVo.isEmpty())
            return null;
        List<Entraineur> listBo = new ArrayList<>();
        for (EntraineurVo e : listVo)
            listBo.add(toBo(e));
        return listBo;
    }

}