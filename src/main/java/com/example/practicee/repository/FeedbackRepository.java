package com.example.practicee.repository;

import com.example.practicee.entity.FeedbackEntity;
import com.example.practicee.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity,Integer> {
 List<FeedbackEntity>findByUser(UserEntity user);
}
