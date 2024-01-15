package com.fer.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fer.demo.persistence.entity.Task;
import com.fer.demo.service.dto.TaskDTO;

@Component
public class TaskDTOToTask implements IMapper<TaskDTO, Task> {

    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedData(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus("NEW");
        
       return task;
    }
    
}
