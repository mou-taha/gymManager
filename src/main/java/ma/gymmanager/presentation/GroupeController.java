package ma.gymmanager.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.gymmanager.Service.IEntraineurService;
import ma.gymmanager.Service.IGroupeService;
import ma.gymmanager.Service.ISportService;
import ma.gymmanager.domaine.AdherentVo;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.GroupeConverter;
import ma.gymmanager.domaine.GroupeVo;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.exceptions.GroupeHadAdherentException;
import ma.gymmanager.model.Adherent;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Groupe;

@Controller
@RequestMapping("/groupes")
public class GroupeController {

    @Autowired
    IGroupeService groupeService;

    @Autowired
    ISportService sportService;

    @Autowired
    IEntraineurService entraineurService;

    @RequestMapping(value = { "/", "/{page}", "" })
    public ModelAndView list(@PathVariable(required = false) Integer page,
            @ModelAttribute("groupeVoEdit") GroupeVo groupeVoEdit, @ModelAttribute("errorMsg") String errorMsg) {
        page = page == null ? 0 : page;
        ModelAndView mv = new ModelAndView("/groupes/groupes");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (groupeVoEdit == null)
            mv.addObject("groupeVoEdit", new GroupeVo());
        Page<Groupe> pageable = groupeService.findAll(page, 5);
        mv.addObject("sportList", sportService.getAllSports());
        mv.addObject("entraineurList", entraineurService.findAll());
        mv.addObject("groupeVo", new GroupeVo());
        mv.addObject("groupeList", GroupeConverter.toListVo(pageable.getContent()));
        mv.addObject("totalPage", pageable.getTotalPages());
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("curentPage", page);
        if (errorMsg == null)
            mv.addObject("errorMsg", new String(""));
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("groupeVo") GroupeVo groupeVo) {
        ModelAndView mv = new ModelAndView();
        groupeService.save(groupeVo);
        mv.setViewName("redirect:/groupes/");
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("groupeVoEdit") GroupeVo groupeVo) {
        ModelAndView mv = new ModelAndView();
        groupeService.save(groupeVo);
        mv.setViewName("redirect:/groupes/");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable int id, @ModelAttribute("errorMsg") String errorMsg,
            RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        try {
            groupeService.delete(id);
        } catch (GroupeHadAdherentException e) {
            ra.addFlashAttribute("errorMsg", errorMsg = e.getMessage());
        }
        mv.setViewName("redirect:/groupes/");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        GroupeVo entraineurVoEdit = groupeService.getById(id);
        mv.setViewName("redirect:/groupes/");
        ra.addFlashAttribute("groupeVoEdit", entraineurVoEdit);
        return mv;
    }

    @RequestMapping(path = "/entraineur", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getEntraineurBySport(@RequestParam String sportid) {
        ArrayList<EntraineurVo> sportL = entraineurService.getEntraineurBySport(Integer.parseInt(sportid));
        HashMap<String, String> map = new HashMap<String, String>();
        for (EntraineurVo e : sportL) {
            map.put(e.getId() + "", e.getNom() + " " + e.getPrenom());
        }
        return ResponseEntity.ok(map);
    }

}