package ma.gymmanager.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ma.gymmanager.Service.IPlanningService;
import ma.gymmanager.model.Planning;

@Controller
@RequestMapping("/plannings")
public class PlanningController {

    @Autowired
    IPlanningService planningService;

    @RequestMapping(value = {"","/"})
    public ModelAndView list(){
        ModelAndView mv=new ModelAndView("/plannings/plannings");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("planningList", planningService.findAll());
        mv.addObject("planningVo", new Planning());
        return mv;
    }

    @RequestMapping("/consultation")
    public ModelAndView consultation(){
        ModelAndView mv=new ModelAndView("/plannings/consultation/consultationPlannings");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("userLogIn", auth.getName());
        return mv;
    }
}