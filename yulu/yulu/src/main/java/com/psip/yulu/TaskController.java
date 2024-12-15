package com.psip.yulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
class TaskController {
    private HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();
    private HashMap<String, ArrayList<Task>> byStatus = new HashMap<String, ArrayList<Task>>();
    private Integer runningID = 0;

    // add a task to our task manager
    @PostMapping
    public Task createTask(@RequestParam("title") String title,
                           @RequestParam(value = "description", required = false) String description,
                           @RequestParam("due_date") Date due_date,
                           @RequestParam(value = "status", required = false) String status) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title is required.");
        }
        validateStatus(status);
        Task task = new Task(runningID++, title, description, due_date, status);
        if (!byStatus.containsKey(status)) {
            ArrayList<Task> list = new ArrayList<Task>();
            list.add(task);
            byStatus.put(status, list);
        }
        else byStatus.get(status).add(task);
        tasks.put(task.getID(), task);
        return task;
    }

    // return either all tasks or a collection of tasks with a certain status
    @GetMapping
    public ArrayList<Task> getTasks(@RequestParam(value = "status", required = false) String status) {
        if (status == null) return new ArrayList<>(tasks.values());
        else validateStatus(status);
        return byStatus.get(status);
    }

    // offer options to update a task's title and/or status
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Integer id,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "status", required = false) String status) {
        Task task = tasks.get(id);
        if (title != null) task.setTitle(title);
        if (status != null) {
            validateStatus(status);
            // update the byStatus map as well as the task itself
            String oldStatus = task.getStatus();
            byStatus.get(oldStatus).remove(task);
            task.setStatus(status);
            byStatus.get(status).add(task);
        }
        return task;
    }

    // delete a task from our task manager
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        if (tasks.get(id) == null)
            throw new IllegalArgumentException("invalid id");
        else tasks.remove(id);
    }

    // private helper method to validate a status argument
    private void validateStatus(String status) {
        if (!((status.equals("In Progress") || status.equals("Completed")) ||
                status.equals("Pending")))
            throw new IllegalArgumentException("invalid status");
    }
}
