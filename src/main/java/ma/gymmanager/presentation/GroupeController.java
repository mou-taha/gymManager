package ma.gymmanager.presentation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.GroupeConverter;
import ma.gymmanager.domaine.GroupeVo;
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
            @ModelAttribute("groupeVoEdit") GroupeVo groupeVoEdit) {
        page = page == null ? 0 : page;
        ModelAndView mv = new ModelAndView("/groupes/groupes");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (groupeVoEdit == null)
            mv.addObject("groupeVoEdit", new GroupeVo());
        Page<Groupe> pageable=groupeService.findAll(page, 5);
        mv.addObject("sportList", sportService.getAllSports());
        mv.addObject("entraineurList", entraineurService.findAll());
        mv.addObject("groupeVo", new GroupeVo());
        mv.addObject("listGrpupe",GroupeConverter.toListVo(pageable.getContent()));
        mv.addObject("totalPage", pageable.getTotalPages());
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("curentPage", page);
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("groupeVo") GroupeVo groupeVo) {
        ModelAndView mv = new ModelAndView();
        groupeService.add(groupeVo);
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
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        groupeService.delete(id);
        mv.setViewName("redirect:/groupes/");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        GroupeVo entraineurVoEdit = groupeService.getById(id);
        mv.setViewName("redirect:/groupes/"); 
        ra.addFlashAttribute("entraineurVoEdit", entraineurVoEdit);
        return mv;
    }

    @RequestMapping(path = "/entraineur",produces = "application/json")
    @ResponseBody
    public List<EntraineurVo> getEntraineurBySport(@RequestParam String sportid){
        List<EntraineurVo> sportL=entraineurService.getEntraineurBySport(Integer.parseInt(sportid));
        return sportL;
    }

}