package com.davida.finalApp.web;

import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.model.User;
import com.davida.finalApp.repository.SignRequestDao;
import com.davida.finalApp.service.SignRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("signRequest")
public class SignRequestController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    private SignRequestService signRequestService;

    @Autowired
    private SignRequestDao signRequestDao;


/*

    @Autowired
    private EditRequestDao editRequestDao;
*/

    User user = new User();

    @RequestMapping("/runjob") //only if not already loaded
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
//        if (user.getDepartments()== BAKERY)
        return "/viewAllSignRequests";
    }
/*
    @RequestMapping(value = "/editSignRequest", method = RequestMethod.GET) //check to make sure new line/table created
    public String addSignRequestForm(Model model) {
        model.addAttribute("signRequestForm", new SignRequest());
        System.out.println("In the edit Request GET method");

        return "editSignRequest";
    }

    @RequestMapping(value = "/editSignRequest", method = RequestMethod.POST)
    public String editSignRequest(@ModelAttribute("signRequestForm") SignRequest signRequestForm, Model model) {
        SignRequest signRequest = new SignRequest();

        model.addAttribute("editDeliverable", signRequest.getEditDeliverable());
        model.addAttribute("editCopy", signRequest.getEditCopy());

        signRequestService.save(signRequestForm);

        System.out.println(signRequestForm.getEditDeliverable());
        System.out.println(signRequestForm.getEditCopy());

        return "redirect:/runjob";
    }*/
/*
    @RequestMapping(value = "/editSignRequest",method = RequestMethod.GET)
    public String setupForm(Model model)
    {
        SignRequest signRequest = new SignRequest();
        model.addAttribute("signRequest", signRequest);
        return "editSignRequest";
    }

    @RequestMapping(value = "/editSignRequest",method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("employee") SignRequest signRequest,
                             BindingResult result, SessionStatus status)
    {

        //Store the employee information in database
        //manager.createNewRecord(employeeVO);

        //Mark Session Complete
        status.setComplete();
        return "redirect:viewAllSignRequests";
    }*/




/*
    @RequestMapping(value="editSignRequests",  method = RequestMethod.GET)
    public String saveEdit(@ModelAttribute("editDeliverable") String editDeliverable, @ModelAttribute("editCopy") String editCopy,
                           BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        SignRequest signRequest = new SignRequest();
        model.addAttribute("editDeliverable", signRequest.getEditDeliverable());
        model.addAttribute("editCopy", signRequest.getEditCopy());
 try {
//            User user = new User(email, name);
            signRequestDao.save(signRequest);
            model.addAttribute("signrequests", signRequestDao.findAll());

            return "redirect:/viewAllSignRequests";
        }
        catch (Exception e) {
            return "Error creating user: " + e.toString();
        }
    }
*/

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
