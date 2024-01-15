package com.fer.demo.service.dto;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class TaskDTO {
    private String title ;
    private String description;
    private LocalDateTime eta ;
}
