package com.example.practicee.controller;
import com.example.practicee.entity.FeedbackEntity;
import com.example.practicee.entity.UserEntity;
import com.example.practicee.service.FeedbackService;
import com.example.practicee.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {


    @GetMapping("/register")
    public String registerpage(){
        return "register";
    }

    @Autowired
    private UserService userService;
    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute UserEntity user, Model model){

        try{
            userService.registerUser(user);
            return "redirect:/login";
        }
        catch(RuntimeException e){
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
    @GetMapping("/login")
    public String loginpage(){
        return "login";
    }

    @PostMapping("/login-user")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session){

        UserEntity user = userService.login(email,password);
        session.setAttribute("loggedInUser",user);
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin";
        }

        return "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks")
    public String feedbackPage(Model model,HttpSession session) {
        UserEntity user=(UserEntity)session.getAttribute("loggedInUser");
        if(user == null){
            return "redirect:/login";
        }

        model.addAttribute("feedbacks",feedbackService.getFeedbackByUser(user));
        return "feedbacks";
    }
    @PostMapping("/feedbacks")
    public String addFeedback(@ModelAttribute FeedbackEntity feedback,HttpSession session) {
        feedback.setStatus("Pending");
        UserEntity user = (UserEntity) session.getAttribute("loggedInUser");
        feedback.setUser(user);
        feedbackService.addFeedback(feedback);


        return "redirect:/feedbacks";
    }


    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/admin")
    public String adminPage(Model model, HttpSession session){
        UserEntity user =
                (UserEntity) session.getAttribute("loggedInUser");
        if(user == null){
            return "redirect:/login";
        }
        if(!user.getRole().equalsIgnoreCase("ADMIN")){
            return "redirect:/feedbacks";
        }
        model.addAttribute("feedbacks",
                feedbackService.getAllFeedback());

        return "admin";
    }
    @GetMapping("/approve/{id}")
    public String approveFeedback(@PathVariable Integer id){
        FeedbackEntity feedback=feedbackService.getFeedbackById(id);
        feedback.setStatus("Approved");
        feedbackService.updateFeedback(id,feedback);
        return "redirect:/admin";
    }
    @GetMapping("/reject/{id}")
    public String rejectFeedback(@PathVariable Integer id){
        FeedbackEntity feedback=feedbackService.getFeedbackById(id);
        feedback.setStatus("Rejected");
        feedbackService.updateFeedback(id,feedback);
        return "redirect:/admin";
    }
    @GetMapping("/delete-feedback/{id}")
    public String deleteFeedback(@PathVariable Integer id){
        feedbackService.deleteFeedback(id);
        return "redirect:/feedbacks";
    }
    @GetMapping("/edit/{id}")
    public String editFeedback(
            @PathVariable Integer id ,Model model){
        FeedbackEntity feedback= feedbackService.getFeedbackById(id);
        model.addAttribute("feedback",feedback);
        return "edit-feedback";
    }
    @PostMapping("/update/{id}")
    public String updateFeedback(
            @PathVariable Integer id,@ModelAttribute FeedbackEntity feedback){
        FeedbackEntity existingFeedback=feedbackService.getFeedbackById(id);
        existingFeedback.setSubject(feedback.getSubject());
        existingFeedback.setMessage(feedback.getMessage());
        feedbackService.updateFeedback(id,existingFeedback);
        return "redirect:/feedbacks";
    }
    @GetMapping("/admin/delete/{id}")
    public String adminDeleteFeedback(@PathVariable Integer id){
        feedbackService.deleteFeedback(id);
        return "redirect:/admin";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

}
