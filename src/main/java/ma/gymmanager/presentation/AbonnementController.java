package ma.gymmanager.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.gymmanager.Service.IAbonnementService;

@Controller
@RequestMapping("/entraineurs")
public class AbonnementController {

    @Autowired
    IAbonnementService abonnementService;

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
            map.put(e.getId() + "", e.getNom()+" "+e.getPrenom());
        }
        return ResponseEntity.ok(map);
    }
    
}