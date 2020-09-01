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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.gymmanager.Service.IUserService;
import ma.gymmanager.domaine.RoleVo;
import ma.gymmanager.domaine.UserConverter;
import ma.gymmanager.domaine.UserVo;
import ma.gymmanager.model.User;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = { "/", "/{page}", "" })
    public ModelAndView list(@PathVariable(required = false) Integer page,
            @ModelAttribute("userVoEdit") UserVo userVoEdit, @ModelAttribute("errorMsg") String errorMsg) {
        page = page == null ? 0 : page;
        ModelAndView mv = new ModelAndView("/superadmin/superadmin");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (userVoEdit == null)
            mv.addObject("userVoEdit", new UserVo());
        Page<User> pageable = userService.getAlluUsers(page, 5);
        mv.addObject("userVo", new UserVo());
        mv.addObject("userList", UserConverter.toVoList(pageable.getContent()));
        List<RoleVo> r = userService.getAllRoles();
        mv.addObject("roleList", r);
        mv.addObject("totalPage", pageable.getTotalPages());
        mv.addObject("userLogIn", auth.getName());
        mv.addObject("curentPage", page);
        if (errorMsg == null)
            mv.addObject("errorMsg", new String(""));
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("userVoEdit") UserVo userVoEdit) {
        ModelAndView mv = new ModelAndView();
        userService.save(userVoEdit);
        mv.setViewName("redirect:/superadmin/");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("abonnementVo") UserVo userVo) {
        ModelAndView mv = new ModelAndView();
        userService.add(userVo);
        mv.setViewName("redirect:/superadmin/");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        userService.delete(id);
        mv.setViewName("redirect:/superadmin/");
        return mv;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        UserVo userVoEdit = userService.getUserById(id);
        mv.setViewName("redirect:/superadmin/");
        ra.addFlashAttribute("userVoEdit", userVoEdit);
        return mv;
    }

}