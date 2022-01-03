package tasks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Task {
    public String taskName;
    public String status;



    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, String status) {
        this.taskName = taskName;
        this.status = status;
    }



    public Task() {
    }




    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "Task " + "\"" +  taskName + "\"" + ", status: " + status + "\n";
    }


}
