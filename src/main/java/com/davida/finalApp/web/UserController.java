package com.davida.finalApp.web;

import com.davida.finalApp.model.Department;
import com.davida.finalApp.model.User;
//import com.davida.finalApp.repository.DepartmentDao;
import com.davida.finalApp.service.SecurityService;
import com.davida.finalApp.service.UserService;
import com.davida.finalApp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

/*    @Autowired
    private DepartmentDao departmentDao;*/


//    void initLists(ModelMap model) {
//        model.addAttribute("departments", departmentDao.loadAllDepartments());
//    }

    /*void initLists(Model model) { //this one works, numbers only
        User user = new User();
        List<Long> departments = new ArrayList<Long>();
        departments.add(1L);
        departments.add(2L);
        departments.add(3L);
        departments.add(4L);
        departments.add(5L);
        departments.add(6L);
        model.addAttribute("user", user);
        model.addAttribute("departments", departments);
    }*/
    void initLists(Model model) {
        User user = new User();
        List<String> departments = new ArrayList<String>();
        departments.add("GroBody");
        departments.add("Meat/Seafood");
        departments.add("Produce");
        departments.add("PFDS");
        departments.add("Specialty");
        departments.add("Bakery");
        model.addAttribute("user", user);
        model.addAttribute("departments", departments);
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        initLists(model);
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, @ModelAttribute Set<Department> departments, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        model.addAttribute("storeNames", User.StoreName.values());
        model.addAttribute("departments", userForm.getDepartments());

        if (bindingResult.hasErrors()) {
            initLists(model); //instead send what checkbox selection we capture back

            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/runjob";
    }

/*    @Controller
    public class FoodController {

        @RequestMapping(value="/food-result")
        public ModelAndView processFuits(@ModelAttribute Food food) {
            ModelAndView modelAndView = new ModelAndView("food-result");
            modelAndView.addObject("food", food);
            return modelAndView;
        }

    }*/


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        System.out.println();
        return "welcome";
    }

}
