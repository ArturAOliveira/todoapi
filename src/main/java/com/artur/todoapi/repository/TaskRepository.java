package com.artur.todoapi.repository;

import com.artur.todoapi.model.Status;
import com.artur.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

        List<Task> findByStatus(Status status);
        List<Task> findByCategory(String category);
}
