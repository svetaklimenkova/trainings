package by.slivki.trainings.rest;

import by.slivki.trainings.dao.jpa.Role;
import by.slivki.trainings.dao.jpa.RoleEnum;
import by.slivki.trainings.rest.mapper.ApplicationMapper;
import by.slivki.trainings.service.api.ApplicationService;
import by.slivki.trainings.service.api.UserService;
import by.slivki.trainings.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class DefaultController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private UserHelper userHelper;

    @GetMapping("/")
    public String home1() {
        return getHomePage();
    }

    @GetMapping("/home")
    public String getHomePage() {
        UserDetails userDetails = userHelper.getCurrentUser();

        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_ADMIN).getRoleName());
        GrantedAuthority trainer = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_TRAINER).getRoleName());
        GrantedAuthority user = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_USER).getRoleName());

        String page = "/home";
        if (userDetails != null && userDetails.getAuthorities().contains(admin)) {
            page = "/admin/applications";
        } else if (userDetails != null && userDetails.getAuthorities().contains(trainer)) {
            page = "/trainer/trainings";
        } else if (userDetails != null && userDetails.getAuthorities().contains(user)) {
            page = "/user/trainings";
        }

        return page;
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/signUp";
    }

    @GetMapping("/error")
    public String error() {
        return "/error/404";
    }

    @GetMapping("/applications/password")
    public String applicationPassword() {
        return "/applications/password";
    }

    @GetMapping("/applications/trainer")
    public String applicationTrainer() {
        return "/applications/trainer";
    }

    @GetMapping("/applications")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String applications() {
        return "/admin/applications";
    }

    @GetMapping("/applications/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView applicationById(@PathVariable int id, Locale locale) {
        ModelAndView modelAndView = new ModelAndView("/admin/application");
        modelAndView.addObject("application",
                applicationMapper.toApplicationDto(applicationService.getApplicationById(id), locale)
        );
        return modelAndView;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String users() {
        return "/admin/users";
    }

    @GetMapping("/categories")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String categories() {
        return "/admin/categories";
    }

    @GetMapping("/trainings")
    public String trainings() {
        UserDetails userDetails = userHelper.getCurrentUser();

        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_ADMIN).getRoleName());
        GrantedAuthority trainer = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_TRAINER).getRoleName());
        GrantedAuthority user = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_USER).getRoleName());

        String page = "/home";
        if (userDetails != null && userDetails.getAuthorities().contains(admin)) {
            page = "/error/403";
        } else if (userDetails != null && userDetails.getAuthorities().contains(trainer)) {
            page = "/trainer/trainings";
        } else if (userDetails != null && userDetails.getAuthorities().contains(user)) {
            page = "/user/trainings";
        }

        return page;
    }

    @GetMapping("/trainings/create/")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    public String trainingToCreate() {
        return "/trainer/create";
    }

    @GetMapping("/trainings/{id}")
    public String trainingById(@PathVariable int id) {
        UserDetails userDetails = userHelper.getCurrentUser();

        GrantedAuthority admin = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_ADMIN).getRoleName());
        GrantedAuthority trainer = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_TRAINER).getRoleName());
        GrantedAuthority user = new SimpleGrantedAuthority(new Role(RoleEnum.ROLE_USER).getRoleName());

        String page = "/home";
        if (userDetails != null && userDetails.getAuthorities().contains(admin)) {
            page = "/error/403";
        } else if (userDetails != null && userDetails.getAuthorities().contains(trainer)) {
            page = "/trainer/training";
        } else if (userDetails != null && userDetails.getAuthorities().contains(user)) {
            page = "/user/training";
        }

        return page;
    }

    @GetMapping("/trainings/edit/{id}")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    public String trainingToEditById() {
        return "/trainer/edit/training";
    }

    @GetMapping("/user/trainings")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userTrainings() {
        return "/user/mytrainings";
    }

    @GetMapping("/user/trainings/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userTrainingById() {
        return "/user/mytraining";
    }

    @GetMapping("/user/reports")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String reportsToUser() {
        return "/user/reports";
    }

    @GetMapping("/reports")
    @PreAuthorize("hasRole('ROLE_TRAINER')")
    public String reportsToTrainer() {
        return "/trainer/reports";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_TRAINER')")
    public String profile() {
        UserDetails userDetails = userHelper.getCurrentUser();
        if (userHelper.isRoleAuthority(userDetails, RoleEnum.ROLE_TRAINER)) {
            return "/trainer/profile";
        } else {
            return "/user/profile";
        }
    }

}