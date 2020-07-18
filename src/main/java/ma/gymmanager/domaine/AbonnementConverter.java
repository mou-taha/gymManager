package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Abonnement;

public class AbonnementConverter {
    public static AbonnementVo toVo(Abonnement bo) {
        if (bo == null)
            return null;
        AbonnementVo vo = new AbonnementVo();
        vo.setAdherent(AdherentConverter.toVo( bo.getAdherent()));
        vo.setSport(SportConverter.toVo(bo.getSport()));
        vo.setDateDebut(bo.getDateDebut());
        vo.setDatePaiment(bo.getDatePaiment());
        vo.setId(bo.getId());
        vo.setNbMois(bo.getNbMois());
        return vo;
    }

    public static Abonnement toBo(AbonnementVo Vo) {
        if (Vo == null)
            return null;
        Abonnement bo = new Abonnement();
        bo.setAdherent(AdherentConverter.toBo(Vo.getAdherent()));
        bo.setSport(SportConverter.toBo(Vo.getSport()));
        bo.setDateDebut(Vo.getDateDebut());
        bo.setDatePaiment(Vo.getDatePaiment());
        bo.setId(Vo.getId());
        bo.setNbMois(Vo.getNbMois());
        return bo;
    }

    public static List<AbonnementVo> toListVo(List<Abonnement> listBo) {
        if (listBo == null || listBo.isEmpty())
            return null;
        List<AbonnementVo> listVo = new ArrayList<>();
        for (Abonnement a : listBo)
            listVo.add(toVo(a));
        return listVo;
    }

  
    public static List<Abonnement> toListBo(List<AbonnementVo> listVo) {
        if (listVo == null || listVo.isEmpty())
            return null;
        List<Abonnement> listBo = new ArrayList<>();
        for (AbonnementVo a : listVo)
            listBo.add(toBo(a));
        return listBo;
    }

}