package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Sport;

public class SportConverter {
    public static SportVo toVo(Sport bo) {
        if (bo == null)
            return null;
        SportVo vo = new SportVo();
        vo.setEntraineur(EntraineurConverter.toVo(bo.getEntraineur()));
        vo.setId(bo.getId());
        vo.setNom(bo.getNom());
        vo.setMinAge(bo.getMinAge());
        vo.setPrixMois(bo.getPrixMois());
        vo.setPrixSeance(bo.getPrixSeance());
        vo.setDescription(bo.getDescription());
        return vo;
    }

    public static Sport toBo(SportVo vo) {
        if (vo == null)
            return null;
        Sport bo = new Sport();
        bo.setEntraineur(EntraineurConverter.toBo( vo.getEntraineur()));
        bo.setId(vo.getId());
        bo.setNom(vo.getNom());
        bo.setMinAge(vo.getMinAge());
        bo.setPrixMois(vo.getPrixMois());
        bo.setPrixSeance(vo.getPrixSeance());
        bo.setDescription(vo.getDescription());
        return bo;
    }

    public static List<SportVo> toListVo(List<Sport> listBo) {
        List<SportVo> listVo = new ArrayList<>();
        for (Sport s : listBo)
            listVo.add(toVo(s));
        return listVo;
    }


    public static List<Sport> toListBo(List<SportVo> listVo) {
        List<Sport> listBo = new ArrayList<>();
        for (SportVo s : listVo)
            listBo.add(toBo(s));
        return listBo;
    }
}