package com.example.practicee.entity;

import com.example.practicee.repository.UserRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Subject cannot be empty")
    private String subject;

    @NotBlank(message = "Message cannot be empty")
    private String message;

    private String status;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
