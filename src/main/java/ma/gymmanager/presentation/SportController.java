package ma.gymmanager.presentation;

import java.util.List;

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

import ma.gymmanager.Service.IEntraineurService;
import ma.gymmanager.Service.ISportService;
import ma.gymmanager.domaine.EntraineurVo;
import ma.gymmanager.domaine.SportConverter;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.model.Sport;

@Controller
@RequestMapping("/sports")
public class SportController {

    @Autowired
    ISportService sportService;

    @Autowired
    IEntraineurService entraineurService;

    @ModelAttribute("entraineurList")
    public List<EntraineurVo> entraineurList(){
        return entraineurService.findAll();
    }

    @RequestMapping(value = { "", "/", "/{page}" })
    public ModelAndView list(@ModelAttribute("sportVoEdit") SportVo sportVoEdit,
            @PathVariable(required = false) Integer page) {
        ModelAndView mv = new ModelAndView();
        if (sportVoEdit == null)
            mv.addObject("sportVoEdit", new SportVo());
        mv.addObject("sportVo", new SportVo());
        page = page == null ? 0 : page;
        Page<Sport> pageable=sportService.findAll(page, 3);
        List<SportVo> list = SportConverter.toListVo(pageable.getContent());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("sportList", list);
        mv.addObject("totalPage", pageable.getTotalPages());
        mv.addObject("curentPage", page);
        mv.setViewName("/sports/sports");
        return mv;
    }

    @RequestMapping(value = { "/add" })
    public ModelAndView add(@ModelAttribute("sportVo") SportVo sportVo) {
        ModelAndView mv = new ModelAndView();
        sportService.save(sportVo);
        mv.setViewName("redirect:/sports");
        return mv;
    }

    @RequestMapping(value = { "/save" })
    public ModelAndView save(@ModelAttribute("sportVoEdit") SportVo sportVo) {
        ModelAndView mv = new ModelAndView();
        sportService.save(sportVo);
        mv.setViewName("redirect:/sports");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        ra.addFlashAttribute("sportVoEdit", sportService.getById(id));
        mv.setViewName("redirect:/sports/");
        return mv;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        sportService.delete(id);
        mv.setViewName("redirect:/sports");
        return mv;
    }
}