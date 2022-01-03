package tasks;

import dataBase.DBHandler;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskRepository {

    DBHandler dbHandler = new DBHandler();

    public void createList() throws SQLException {
        String query = "CREATE TABLE tasks (id int primary key not null auto_increment, taskName VARCHAR (255) not null, status VARCHAR (255) not null)";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public void createTask(String taskName, String status) throws SQLException {
        String query = "INSERT INTO tasks (taskName, status) VALUES (?,?)";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setString(1, taskName);
        preparedStatement.setString(2, status);


        preparedStatement.execute();
        preparedStatement.close();

    }

    public void deleteTask(int id) throws SQLException {
        String query = "DELETE FROM tasks WHERE id=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();
        preparedStatement.close();

    }

    public ArrayList<Task> viewAllTasks() throws SQLException {
        String query = "SELECT * FROM tasks";
        Statement statement = dbHandler.getConnection().createStatement();
        ResultSet results = statement.executeQuery(query);

        ArrayList<Task> tasks = new ArrayList<>();

        while (results.next()) {
            String taskName = results.getString("taskName");
            String status = results.getString("status");

            Task task = new Task(taskName, status);
            tasks.add(task);

        }
        return tasks;

    }

    public ArrayList<Task> viewTasksByStatus(String status) throws SQLException {
        String query = "SELECT * FROM tasks WHERE status=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, status);
        preparedStatement.execute();
        ResultSet result = preparedStatement.getResultSet();

        ArrayList<Task> tasks = new ArrayList<>();
        while (result.next()) {
            String taskName = result.getString("taskName");
                status = result.getString("status");

            Task task = new Task(taskName, status);
            tasks.add(task);
        }
        preparedStatement.close();
        return tasks;

    }


    public void changeTaskStatus(int id, String newStatus) throws SQLException {
        String query = "UPDATE tasks SET status=? WHERE id=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, newStatus);
        preparedStatement.setInt(2, id);

        preparedStatement.execute();
        preparedStatement.close();

    }


}



