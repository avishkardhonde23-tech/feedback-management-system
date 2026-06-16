package com.example.practicee.service;

import com.example.practicee.entity.FeedbackEntity;
import com.example.practicee.entity.UserEntity;
import com.example.practicee.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public FeedbackEntity addFeedback(FeedbackEntity feedback){
        return feedbackRepository.save(feedback);
    }
    public List<FeedbackEntity> getAllFeedback(){
        return feedbackRepository.findAll();
    }
    public FeedbackEntity getFeedbackById(Integer id){
        return feedbackRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Feedback Not Found"));
    }
    public FeedbackEntity updateFeedback(Integer id,FeedbackEntity updatedFeedback){
        FeedbackEntity feedback = feedbackRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("feedback not found"));
        feedback.setSubject(updatedFeedback.getSubject());
        feedback.setMessage(updatedFeedback.getMessage());
        feedback.setStatus(updatedFeedback.getStatus());
        return feedbackRepository.save(feedback);
    }
    public void deleteFeedback(Integer id){
        feedbackRepository.deleteById(id);
    }
    public  List<FeedbackEntity> getFeedbackByUser(UserEntity user){
        return feedbackRepository.findByUser(user);
    }
}
