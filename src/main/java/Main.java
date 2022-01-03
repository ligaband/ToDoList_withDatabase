import tasks.TaskController;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    TaskController taskController = new TaskController();


    public static void main(String[] args) {


        Main main = new Main();
        main.menu();

    }


    void menu() {

        String choice;

        do {
            System.out.println("\nTO DO LIST. Choose an activity");
            System.out.println("\n1. Add new task");
            System.out.println("2. Remove task");
            System.out.println("3. Complete task");
            System.out.println("4. View all tasks");
            System.out.println("5. View tasks by status");
            System.out.println("6. Create To Do List");
            System.out.println("Enter \"Quit\" to exit menu");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                  addTask();
                    break;
                case "2":
                    deleteTask();
                    break;
                case "3":
                completeTask();
                    break;
                case "4":
                    System.out.println(taskController.viewAllTasks());
                    break;
                case "5":
                    viewTasksByStatus();
                    break;
                case "6":
                    System.out.println(taskController.createList());
                case "Quit":
                    System.out.println("Quit menu");
                    break;
                default:
                    break;
            }


        } while (!choice.equalsIgnoreCase("Quit"));
    }


    void addTask() {
        System.out.println("Enter task name");
        String taskName = scanner.nextLine();
        System.out.println("Enter task status: active or completed");
        String status = scanner.nextLine();
        System.out.println(taskController.createTask(taskName, status));



    }

    void deleteTask(){
        System.out.println("Enter task's ID you want to delete");
        int id = intScanner.nextInt();
        taskController.deleteTask(id);
    }

    void completeTask(){
        System.out.println("Enter task's ID you would like to complete");
        int taskId = intScanner.nextInt();
        System.out.println("Enter new status");
        String newStatus = scanner.nextLine();
        System.out.println(taskController.changeTaskStatus(taskId, newStatus));
    }

    void viewTasksByStatus(){
        System.out.println("What status tasks you would like to view: active or completed?");
        String status = scanner.nextLine();
        System.out.println(taskController.viewTasksByStatus(status));
    }


}


