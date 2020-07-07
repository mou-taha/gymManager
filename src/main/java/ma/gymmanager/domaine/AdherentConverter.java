package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Adherent;

public class AdherentConverter {

    public static AdherentVo toVo(Adherent bo) {
        if (bo == null)
            return null;
        AdherentVo vo = new AdherentVo();
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        vo.setPrenom(bo.getPrenom());
        vo.setAdresse(bo.getAdresse());
        vo.setCin(bo.getCin());
        vo.setDateN(bo.getDateN());
        vo.setEmail(bo.getEmail());
        vo.setGroupe_Sanguin(bo.getGroupe_Sanguin());
        vo.setMaladie(bo.getMaladie());
        vo.setPCANom(bo.getPCANom());
        vo.setPCATel(bo.getPCATel());
        vo.setSexe(bo.getSexe());
        vo.setTel(bo.getTel());
        return vo;
    }

    public static Adherent toBo(AdherentVo vo) {
        if (vo == null)
            return null;
        Adherent bo = new Adherent();
        bo.setNom(vo.getNom());
        bo.setId(vo.getId());
        bo.setPrenom(vo.getPrenom());
        bo.setAdresse(vo.getAdresse());
        bo.setCin(vo.getCin());
        bo.setDateN(vo.getDateN());
        bo.setEmail(vo.getEmail());
        bo.setGroupe_Sanguin(vo.getGroupe_Sanguin());
        bo.setMaladie(vo.getMaladie());
        bo.setPCANom(vo.getPCANom());
        bo.setPCATel(vo.getPCATel());
        bo.setSexe(vo.getSexe());
        bo.setTel(vo.getTel());
        return bo;
    }

    public static List<AdherentVo> toListVo(List<Adherent> listBo) {
        List<AdherentVo> listVo = new ArrayList<>();
        for (Adherent a : listBo)
            listVo.add(toVo(a));
        return listVo;
    }
}