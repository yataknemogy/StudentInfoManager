package org.example;

import com.mysql.cj.xdevapi.DeleteStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;


public class Students {


    private static final String name = "yourname" ;
    private static final String password = "yourpassword" ;
    private static final String URL = "yourUrlDatabase";

    public static Connection getConnection ()throws SQLException {
        return DriverManager.getConnection(URL, name, password);
    }

    public void addStudent(String firstName, String secondName, int age, double averageScore){
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students(firstName, secondName, age, averageScore) VALUES(?,?,?,?)")){
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setInt(3, age);
            statement.setDouble(4, averageScore);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeStudent(int id){
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE id = ?")){
                 statement.setInt(1, id);
                 statement.executeUpdate();
                System.out.println("Студент с идентификатором " + id + " был удален!");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void foundStudent(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                System.out.println("Информация о студенте с идентификатором: " + id);
                System.out.println("Имя студента: " + resultSet.getString("firstName"));
                System.out.println("Фамилия студента: " + resultSet.getString("secondName"));
                System.out.println("Возраст студента: " + resultSet.getInt("age"));
                System.out.println("Средний балл студента: " + resultSet.getDouble("averageScore"));
            }
            else{
                System.err.println("Студент с идентификатором " + id + " не был найден!");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editStudent(int id, String firstName, String secondName, int age, double averageScore) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE students SET firstName = ?, secondName = ?, age = ?, averageScore = ? WHERE id = ?")) {
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setInt(3, age);
            statement.setDouble(4, averageScore);
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println("Студент с идентификатором " + id + " был успешно обновлен!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void listStudent(){
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students")) {
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Информация о всех студентах, которые занесены в список!");
            while (resultSet.next()){
                System.out.println("----------------------------------");
                System.out.println("Идентификатор студента: " + resultSet.getInt("id"));
                System.out.println("Имя студента: " + resultSet.getString("firstName"));
                System.out.println("Фамилия студента: " + resultSet.getString("secondName"));
                System.out.println("Возраст студента: " + resultSet.getInt("age"));
                System.out.println("Средний балл студента: " + resultSet.getDouble("averageScore"));
            }
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void sortingStudentAverage(){
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students ORDER BY averageScore")) {
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Информация о всех студентах, которые занесены в список!");
            while (resultSet.next()){
                System.out.println("----------------------------------");
                System.out.println("Идентификатор студента: " + resultSet.getInt("id"));
                System.out.println("Имя студента: " + resultSet.getString("firstName"));
                System.out.println("Фамилия студента: " + resultSet.getString("secondName"));
                System.out.println("Возраст студента: " + resultSet.getInt("age"));
                System.out.println("Средний балл студента: " + resultSet.getDouble("averageScore"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void sortingStudentfirstName(){
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students ORDER BY firstName")) {
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Информация о всех студентах, которые занесены в список!");
            while (resultSet.next()){
                System.out.println("----------------------------------");
                System.out.println("Идентификатор студента: " + resultSet.getInt("id"));
                System.out.println("Имя студента: " + resultSet.getString("firstName"));
                System.out.println("Фамилия студента: " + resultSet.getString("secondName"));
                System.out.println("Возраст студента: " + resultSet.getInt("age"));
                System.out.println("Средний балл студента: " + resultSet.getDouble("averageScore"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
