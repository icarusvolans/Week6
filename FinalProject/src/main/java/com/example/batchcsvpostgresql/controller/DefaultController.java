package com.example.batchcsvpostgresql.controller;

//import TeamMemberDto;
import com.example.batchcsvpostgresql.model.*;
import com.example.batchcsvpostgresql.web.dto.TeamMemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @RequestMapping(value="/")
    public String jspIndex() {
        return "index";
    }

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        TeamMemberDto teamMemberDto = new TeamMemberDto();
        List<String> preCheckedVals = new ArrayList<String>();
        preCheckedVals.add("AllStore");
        teamMemberDto.setDepartments(preCheckedVals);
        List<String> departments = new ArrayList<String>();
        departments.add("GroBody");
        departments.add("Meat/Seafood");
        departments.add("Produce");
        departments.add("PFDS");
        departments.add("Specialty");
        departments.add("Bakery");
        model.addAttribute("teamMember", teamMemberDto);
        model.addAttribute("departments", departments);
        model.addAttribute("stores", TeamMemberDto.StoreName.values());
        return "default/registration";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("logout","logout");
        return "login";
    }

    @RequestMapping("/runjob")
    public String handle() throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return "index";
    }
}
