package com.fer.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fer.demo.persistence.entity.Task;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    public List<Task> findAllByTaskStatus(String string);

    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery=true)
    public void markInitilized(@Param("id") Long id);
}
