package ma.gymmanager.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.gymmanager.model.Groupe;

public class GroupeConverter {

    public static Groupe ToBo(GroupeVo vo){
        Groupe bo=new Groupe();
        bo.setId(vo.getId());
        bo.setNbplace(vo.getNbplace());
        bo.setNom(vo.getNom());
        bo.setSport(SportConverter.toBo(vo.getSport()));
        bo.setAdherents(AdherentConverter.toListBo(vo.getAdherents()));
        bo.setEntraineur(EntraineurConverter.toBo(vo.getEntraineur()));
        return bo;
    }


    public static GroupeVo ToVo(Groupe bo){
        GroupeVo vo=new GroupeVo();
        vo.setId(bo.getId());
        vo.setNbplace(bo.getNbplace());
        vo.setNom(bo.getNom());
        vo.setSport(SportConverter.toVo(bo.getSport()));
        vo.setAdherents(AdherentConverter.toListVo(bo.getAdherents()));
        vo.setEntraineur(EntraineurConverter.toVo(bo.getEntraineur()));
        return vo;
    }

    public static List<Groupe> toListBo(List<GroupeVo> listvo){
        List<Groupe> listBo=new ArrayList<Groupe>();
        for (GroupeVo groupe : listvo) {
            listBo.add(ToBo(groupe));
        }
        return listBo;
    }

    public static List<GroupeVo> toListVo(List<Groupe> listbo){
        List<GroupeVo> listVo=new ArrayList<GroupeVo>();
        for (Groupe groupe : listbo) {
            listVo.add(ToVo(groupe));
        }
        return listVo;
    }
    
}