package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Planning;

public class PlanningConverter {

    public static PlanningVo toVo(Planning bo) {
        if (bo == null)
            return null;
        PlanningVo vo = new PlanningVo();
        vo.setCommentaire(bo.getCommentaire());
        vo.setGroupe(bo.getGroupe());
        vo.setHeurFin(bo.getHeurFin());
        vo.setHeureDebut(bo.getHeureDebut());
        vo.setId(bo.getId());
        vo.setJourSemaine(bo.getJourSemaine());
        return vo;
    }

    public static Planning toBo(PlanningVo vo) {
        if (vo == null)
            return null;
        Planning bo = new Planning();
        bo.setCommentaire(vo.getCommentaire());
        bo.setGroupe(vo.getGroupe());
        bo.setHeurFin(vo.getHeurFin());
        bo.setHeureDebut(vo.getHeureDebut());
        bo.setId(vo.getId());
        bo.setJourSemaine(vo.getJourSemaine());
        return bo;
    }

    public static List<Planning> toListBo(List<PlanningVo> listVo) {
        if (listVo == null || listVo.isEmpty())
            return null;
        List<Planning> listBo = new ArrayList<>();
        for (PlanningVo v : listVo)
            listBo.add(toBo(v));
            return listBo;
    }

    public static List<PlanningVo> toListVo(List<Planning> listBo) {
        if (listBo == null || listBo.isEmpty())
            return null;
        List<PlanningVo> listVo = new ArrayList<>();
        for (Planning b : listBo)
            listVo.add(toVo(b));
            return listVo;
    }
}