package com.fer.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fer.demo.exceptions.ToDoExceptions;
import com.fer.demo.mapper.TaskDTOToTask;
import com.fer.demo.persistence.entity.Task;
import com.fer.demo.persistence.repository.TaskRepository;
import com.fer.demo.service.dto.TaskDTO;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final TaskDTOToTask mapper;
    @Autowired
    public TaskService(TaskRepository taskRepository, TaskDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    } 

    public Task createTask(TaskDTO taskDTO ) {
        Task task = mapper.map(taskDTO);

        return this.taskRepository.save(task);
    }


    public  List <Task> findAll(){
        return this.taskRepository.findAll();
    }

    public  List <Task> findByTaskStatus(String ad){
        return this.taskRepository.findAllByTaskStatus(ad);
    }

    @Transactional
    public void updateTaskFinished(Long id){
        Optional<Task> optionTask=this.taskRepository.findById(id);
        if(optionTask.isEmpty()){
            throw new ToDoExceptions("Task not fouund", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markInitilized(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionTask=this.taskRepository.findById(id);
        if(optionTask.isEmpty()){
            throw new ToDoExceptions("Task not fouund", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }



    
}
