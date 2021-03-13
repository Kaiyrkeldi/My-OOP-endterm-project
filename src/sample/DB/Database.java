package sample.DB;

import sample.Task;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Database extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_ID + "," +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, getiduser());
            prSt.setString(2, user.getFirstName());
            prSt.setString(3, user.getLastName());
            prSt.setString(4, user.getUserName());
            prSt.setString(5, user.getPassword());
            prSt.setString(6, user.getLocation());
            prSt.setString(7, user.getGender());
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ResultSet getTask(){
        ResultSet resSet = null;
        String select = "SELECT * FROM tasks";

        Statement stmt = null;
        try {
            stmt = dbConnection.createStatement();
            resSet = stmt.executeQuery(select);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resSet;
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " +Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public int getiduser(){
        ResultSet resSet = null;
        int counter = 0;
        String select = "SELECT * FROM " + Const.USER_TABLE;
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()) {
                counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return counter;
    }

    public int getidtask(){
        ResultSet resSet = null;
        int counter = 0;
        String select = "SELECT * FROM " + Const.TASKS_TABLE;
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()) {
                counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return counter;
    }

    public void addTask(Task task){
        String insert = "INSERT INTO " + Const.TASKS_TABLE + "("+ Const.USERS_ID + "," +
                Const.TASKS_PROJECT + "," + Const.TASKS_TASK + "," +
                Const.TASKS_DATE + ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, getidtask());
            prSt.setString(2, task.getProject());
            prSt.setString(3, task.getTitle());
            prSt.setString(4, String.valueOf(task.getDueDate()));
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}