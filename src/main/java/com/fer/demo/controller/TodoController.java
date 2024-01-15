package com.fer.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fer.demo.persistence.entity.Task;
import com.fer.demo.service.TaskService;
import com.fer.demo.service.dto.TaskDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController()
@RequestMapping("/tasks")

public class TodoController {
    private final TaskService taskService;

    public TodoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public Task createTask(@RequestBody TaskDTO taskDTO) {
    
        return this.taskService.createTask(taskDTO);
    }

    @GetMapping()
    public List<Task> getAllTasks() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> getAllBySatus(@PathVariable("status") String status) {
        return this.taskService.findByTaskStatus(status);
    }

    @PatchMapping("mark/{id}")
    public ResponseEntity<Void> updateNote (@PathVariable("id") Long id){
        this.taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote (@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
