package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Adherent;

public class AdherentConverter {

    public static AdherentVo toVo(Adherent bo) {
        if (bo == null)
            return null;
        AdherentVo vo = new AdherentVo();
        vo.setUser(bo.getUser());
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        vo.setPrenom(bo.getPrenom());
        vo.setAdresse(bo.getAdresse());
        vo.setCin(bo.getCin());
        vo.setDateN(bo.getDateN());
        vo.setGroupeSanguin(bo.getGroupeSanguin());
        vo.setDateNString(bo.getDateNString());
        vo.setEmail(bo.getEmail());
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
        bo.setUser(vo.getUser());
        bo.setUser(vo.getUser());
        bo.setNom(vo.getNom());
        bo.setId(vo.getId());
        bo.setPrenom(vo.getPrenom());
        bo.setAdresse(vo.getAdresse());
        bo.setGroupeSanguin(vo.getGroupeSanguin());
        bo.setCin(vo.getCin());
        bo.setDateNString(vo.getDateNString());
        bo.setDateN(vo.getDateN());
        bo.setEmail(vo.getEmail());
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

	public static List<Adherent> toListBo(List<AdherentVo> listVo) {
        List<Adherent> listBo = new ArrayList<>();
        for (AdherentVo a : listVo)
            listBo.add(toBo(a));
        return listBo;
	}
}