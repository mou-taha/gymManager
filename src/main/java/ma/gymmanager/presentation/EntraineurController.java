package ma.gymmanager.presentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.gymmanager.Service.EntraineurServiceImpl;
import ma.gymmanager.Service.SportServiceImpl;
import ma.gymmanager.domaine.EntraineurConverter;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.model.Entraineur;
import ma.gymmanager.model.Sport;

@Controller
@RequestMapping("/entraineurs")
public class EntraineurController {

    @Autowired
    EntraineurServiceImpl entraineurService;

    @Autowired
    SportServiceImpl sportService;

    @RequestMapping(value = { "", "/", "{page}" })
    public ModelAndView list(@ModelAttribute("entraineurVoEdit") EntraineurVo entraineurVoEdit,
            @PathVariable(required = false) Integer page) {
        page = page == null ? 0 : page;
        ModelAndView mv = new ModelAndView("/entraineurs/entraineurs");
        mv.addObject("entraineurVo", new EntraineurVo());
        if (entraineurVoEdit == null)
            mv.addObject("entraineurVoEdit", new EntraineurVo());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Page<Entraineur> pageable = entraineurService.findAll(page, 5);
        mv.addObject("sportList", sportService.getAllSports());
        mv.addObject("entraineurList", EntraineurConverter.toListVo(pageable.getContent()));
        mv.addObject("totalPage", pageable.getTotalPages());
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("curentPage", page);
        return mv;
    }


    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("entraineurVo") EntraineurVo entraineurVo) {
        ModelAndView mv = new ModelAndView();
        entraineurService.add(entraineurVo);
        mv.setViewName("redirect:/entraineurs/");
        return mv;
    }


    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("entraineurVoEdit") EntraineurVo entraineurVo) {
        ModelAndView mv = new ModelAndView(); 
        entraineurService.save(entraineurVo);
        mv.setViewName("redirect:/entraineurs");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        entraineurService.delete(id);
        mv.setViewName("redirect:/entraineurs/");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        EntraineurVo entraineurVoEdit = entraineurService.getById(id);
        entraineurVoEdit.getSports();
        for(SportVo s:entraineurVoEdit.getSports()){
            System.out.println(s.getId()+"<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(s.getSport()+"<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        mv.setViewName("redirect:/entraineurs");
        ra.addFlashAttribute("entraineurVoEdit", entraineurVoEdit);
        return mv;
    }
}