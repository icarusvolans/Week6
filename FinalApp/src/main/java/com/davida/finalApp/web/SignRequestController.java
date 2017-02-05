package com.davida.finalApp.web;

//import com.davida.finalApp.model.EditRequest;
import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.model.User;
//import com.davida.finalApp.repository.EditRequestDao;
import com.davida.finalApp.repository.SignRequestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SignRequestController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    private SignRequestDao signRequestDao;
/*

    @Autowired
    private EditRequestDao editRequestDao;
*/

    User user = new User();

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

        return "redirect:/viewAllSignRequests";
    }

/*    @RequestMapping(value = "/viewSignRequestsByDepartment");
    public String viewDepartmentSignRequests(ModelMap model) {
        model.addAttribute("signRequests", signRequestDao.loadAllSignRequests());
        if (user.getDepartments() == "Bakery" )
        return "/viewDepartmentSignRequests";
            }*/

    @RequestMapping(value = "viewAllSignRequests")
    public String viewAllSignRequests(ModelMap model) {
        model.addAttribute("signRequests", signRequestDao.loadAllSignRequests());
        return "/viewAllSignRequests";
    }


/*    @RequestMapping(value="editSignRequests")
    public View saveEditedRequest(EditRequest editRequest) {
        editRequestDao.save(editRequest);
        return new RedirectView("/viewAllSignRequests");
    }*/

//    @RequestMapping(value = "editSignRequests")
//    public String editSignRequests(ModelMap model) {
//        model.addAttribute("signRequests", signRequestDao.loadAllSignRequests());
//        return "redirect:/viewAllSignRequests";
//    }

/*    @RequestMapping(value="editSignRequests")
    public String saveEdit(SignRequest signRequest) {
//    public String saveNewCategory(@ModelAttribute("category") Category category) {
        if(signRequest != null) {
            signRequestDao.save(signRequest);
        } else {
            System.out.println("ERROR: did NOT save new signRequest, signRequest was NULL!");
        }
        return "redirect:/viewAllSignRequests";
    }*/
//button at the end of each line, knows to update that one. insert into table, show only most recent update or if multiple, show all updates
}
