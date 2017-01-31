package com.example.batchcsvpostgresql.controller;

import com.example.batchcsvpostgresql.dao.SignRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/signRequests/")
public class ServletController {

    @Autowired
    private SignRequestDao signRequestDao;

    @RequestMapping(value = "viewAllSignRequests")
    public String viewAllSignRequests(ModelMap model) {
        model.addAttribute("signRequests", signRequestDao.loadAllSignRequests());
        System.out.println("In Servlet Controller");
        return "/signRequest/viewAllSignRequests";
/*    }
    @RequestMapping(value="editSignRequest")
    public String editSignRequest(SignRequest signRequest) {
        if(signRequest != null) {
            signRequestDao.save(signRequest);
        } else {
            System.out.println("ERROR: did NOT edit sign request, game was NULL!");
        }
        return "redirect:/games/viewAllGames";
    }*/
    }
}