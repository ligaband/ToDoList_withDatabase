package tasks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskController {

    TaskRepository taskRepository = new TaskRepository();
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> completedTasks = new ArrayList<>();

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(ArrayList<Task> completedTasks) {
        this.completedTasks = completedTasks;
    }


    public String createList() {
        try {
            taskRepository.createList();
            return "List created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating list";
        }
    }

    public String createTask(String taskName, String status) {
        try {
            taskRepository.createTask(taskName, status);
            return "Task created successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating task!";
        }

    }

    public void deleteTask(int id) {
        try {
            taskRepository.deleteTask(id);
            System.out.println("Task deletes successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> viewAllTasks() {
        try {
            return taskRepository.viewAllTasks();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Task> viewTasksByStatus(String status) {
        try {
            return taskRepository.viewTasksByStatus(status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String changeTaskStatus(int id, String newStatus) {
        try {
            taskRepository.changeTaskStatus(id, newStatus);
            return "Task status updated successfully";
        } catch (SQLException e) {
            System.out.println(e);
            return "Can't update task status";

        }
    }


}
