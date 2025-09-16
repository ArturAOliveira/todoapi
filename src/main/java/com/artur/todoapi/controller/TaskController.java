package com.artur.todoapi.controller;

import com.artur.todoapi.model.Task;
import com.artur.todoapi.model.Status;
import com.artur.todoapi.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAll(@RequestParam(required = false) Status status,
                             @RequestParam(required = false) String category) {
        if (status != null) {
            return repository.findByStatus(status);
        } else if (category != null) {
            return repository.findByCategory(category);
        } else {
            return repository.findAll();
        }
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task) {
        return repository.save(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setCategory(task.getCategory());
        return repository.save(existingTask);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
