package com.example.batchcsvpostgresql.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.batchcsvpostgresql.model.Department;
import com.example.batchcsvpostgresql.model.TeamMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/welcome")
public class TMController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model) {
        TeamMember teamMember = new TeamMember();
        List<String> preCheckedVals = new ArrayList<String>();
        preCheckedVals.add("AllStore");
        teamMember.setDepartments(preCheckedVals);
        List<String> departments = new ArrayList<String>();
        departments.add("GroBody");
        departments.add("Meat/Seafood");
        departments.add("Produce");
        departments.add("PFDS");
        departments.add("Specialty");
        departments.add("Bakery");
        model.addAttribute("teamMember", teamMember);
        model.addAttribute("departments", departments);
        model.addAttribute("stores", TeamMember.StoreName.values());
        return "default/welcome";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, TeamMember teamMember, BindingResult result) {
        model.addAttribute("teamMember", teamMember);
        return "successMember";
    }

}