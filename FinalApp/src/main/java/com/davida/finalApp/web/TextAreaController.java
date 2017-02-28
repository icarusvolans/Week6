package com.davida.finalApp.web;

import com.davida.finalApp.model.EditRequest;
import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.model.User;
import com.davida.finalApp.validator.SignRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import java.util.Collection;




/*
@Controller
@RequestMapping("/editSignRequest")
public class TextAreaController {

    @Autowired
    @Qualifier(value = "signRequestValidator")
    private Validator validator;

    @Autowired
    private User user;


*//*    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }*//*

    @RequestMapping(method = RequestMethod.POST)
    public String editRequest(@ModelAttribute("username") String username,@ModelAttribute("deliverable") String deliverable, @ModelAttribute("copy") String copy,
            @ModelAttribute("flaggedDeleted") boolean flaggedDeleted, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        EditRequest editRequest = new EditRequest((Collection<User>) user, deliverable, copy, flaggedDeleted);
        model.addAttribute("deliverable", editRequest.getDeliverable());
        model.addAttribute("copy", editRequest.getCopy());
        model.addAttribute("flaggedDeleted", editRequest.isFlaggedDeleted());
        model.addAttribute("dateTime", editRequest.getDateTime());
        return "/editSignRequest";

    }


    }*/


/*
    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model){
        EditRequest editRequest = new EditRequest();
        model.addAttribute("editRequest", editRequest);
        return "/editSignRequest";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            Model model,EditRequest editRequest, BindingResult result) {
//        Model model, @Validated EditRequest editRequest, BindingResult result) {

            String returnVal = "success";
        if(result.hasErrors()) {
            returnVal = "/editSignRequest";
        } else {
            model.addAttribute("editRequest", editRequest);
        }
        return returnVal;
    }

}*/
