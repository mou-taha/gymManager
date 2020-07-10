package ma.gymmanager.presentation;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.gymmanager.Service.IAdherentService;
import ma.gymmanager.domaine.AdherentVo;

@Controller
@RequestMapping("/adherents")
public class AdherentController {

    @Autowired
    IAdherentService adherentService;

    @RequestMapping(value = { "/", "" })
    public ModelAndView page(@ModelAttribute("adherentVoEdit") AdherentVo adherentVoEdit) {
        ModelAndView mv = new ModelAndView("/adherents/ListAdherents");
        mv.addObject("adherentVo", new AdherentVo());
        if (adherentVoEdit == null)
            mv.addObject("adherentVoEdit", new AdherentVo());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("userLogIn", auth.getName());
        return mv;
    }

    @ModelAttribute("adherentsList")
    public List<AdherentVo> list() {
        return adherentService.findAll();
    }

    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("adherentVo") AdherentVo adherentVo) {
        ModelAndView mv = new ModelAndView();
        adherentVo.setDateN(LocalDate.parse(adherentVo.getDateNString()));
        adherentService.add(adherentVo);
        mv.setViewName("redirect:/adherents/");
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("adherentVoEdit") AdherentVo adherentVo){
        ModelAndView mv=new ModelAndView();
        adherentVo.setDateN(LocalDate.parse(adherentVo.getDateNString()));
        adherentService.save(adherentVo);
        mv.setViewName("redirect:/adherents");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        adherentService.delete(id);
        mv.setViewName("redirect:/adherents/");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        AdherentVo adherentVoEdit = adherentService.getById(id);
        adherentVoEdit.setDateNString(adherentVoEdit.getDateN().toString());
        mv.setViewName("redirect:/adherents");
        ra.addFlashAttribute("adherentVoEdit", adherentVoEdit);
        return mv;
    }
}