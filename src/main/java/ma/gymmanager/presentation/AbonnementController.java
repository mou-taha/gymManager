package ma.gymmanager.presentation;

import java.time.LocalDate;

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

import ma.gymmanager.Service.IAbonnementService;
import ma.gymmanager.Service.IAdherentService;
import ma.gymmanager.Service.IEntraineurService;
import ma.gymmanager.Service.ISportService;
import ma.gymmanager.domaine.AbonnementConverter;
import ma.gymmanager.domaine.AbonnementVo;
import ma.gymmanager.domaine.SportVo;
import ma.gymmanager.exceptions.AdherentAgeException;
import ma.gymmanager.model.Abonnement;

@Controller
@RequestMapping("/abonnements")
public class AbonnementController {

    @Autowired
    IAbonnementService abonnementService;

    @Autowired
    ISportService sportService;

    @Autowired
    IAdherentService adherentService;

    @RequestMapping(value = { "/", "/{page}", "" })
    public ModelAndView list(@PathVariable(required = false) Integer page,
            @ModelAttribute("abonnementVoEdit") AbonnementVo abonnementVoEdit,
            @ModelAttribute("errorMsg") String errorMsg, @RequestParam(required = false) String filter) {
        page = page == null ? 0 : page;
        ModelAndView mv = new ModelAndView("/abonnements/abonnements");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (abonnementVoEdit == null)
            mv.addObject("abonnementVoEdit", new AbonnementVo());
        Page<Abonnement> pageable = abonnementService.findAll(page, 5, filter);
        mv.addObject("sportList", sportService.getAllSports());
        mv.addObject("adherentList", adherentService.findAll());
        mv.addObject("abonnementVo", new AbonnementVo());
        mv.addObject("abonnementList", AbonnementConverter.toListVo(pageable.getContent()));
        mv.addObject("totalPage", pageable.getTotalPages());
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("curentPage", page);
        if (errorMsg == null)
            mv.addObject("errorMsg", new String(""));
        mv.addObject("localdate", java.time.LocalDate.now());
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView add(@ModelAttribute("abonnementVo") AbonnementVo abonnementVo,RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        try{
            abonnementService.save(abonnementVo);
        }catch(AdherentAgeException e){
            ra.addAttribute("errorMsg", e.getMessage());
        }
        mv.setViewName("redirect:/abonnements/");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        abonnementService.delete(id);
        mv.setViewName("redirect:/abonnements/");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        AbonnementVo abonnementVoEdit = abonnementService.getById(id);
        abonnementVoEdit.setDateDebutString(abonnementVoEdit.getDateDebut().toString());
        mv.setViewName("redirect:/abonnements/");
        ra.addFlashAttribute("abonnementVoEdit", abonnementVoEdit);
        return mv;
    }

    @RequestMapping(path = "/sportTarif",produces ="application/json")
    @ResponseBody
    public String getSportTarif(@RequestParam Integer sportId){
        SportVo svo= sportService.getById(sportId);
        return svo.getPrixMois()+"";
    }

    // @RequestMapping(path = "/entraineur", produces = "application/json")
    // @ResponseBody
    // public ResponseEntity<?> getEntraineurBySport(@RequestParam String sportid) {
    // ArrayList<EntraineurVo> sportL =
    // entraineurService.getEntraineurBySport(Integer.parseInt(sportid));
    // HashMap<String, String> map = new HashMap<String, String>();
    // for (EntraineurVo e : sportL) {
    // map.put(e.getId() + "", e.getNom() + " " + e.getPrenom());
    // }
    // return ResponseEntity.ok(map);
    // }

}