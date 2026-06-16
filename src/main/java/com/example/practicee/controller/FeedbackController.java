package com.example.practicee.controller;

import com.example.practicee.entity.FeedbackEntity;
import com.example.practicee.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackservice;

    @PostMapping
    public FeedbackEntity addFeedback(@Valid  @RequestBody FeedbackEntity feedback){
        return feedbackservice.addFeedback(feedback);
    }
    @GetMapping
    public List<FeedbackEntity> getAllFeedback(){
        return feedbackservice.getAllFeedback();
    }
    @GetMapping("/{id}")
    public FeedbackEntity getFeedbackById(@PathVariable Integer id){
        return feedbackservice.getFeedbackById(id);
    }
    @PutMapping("/{id}")
    public FeedbackEntity updateFeedback(@PathVariable Integer id,@RequestBody FeedbackEntity feedback){
        return feedbackservice.updateFeedback(id,feedback);
    }
    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable Integer id){
        feedbackservice.deleteFeedback(id);
        return "Feedback Deleted Successfully";
    }

}
